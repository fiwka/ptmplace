package xyz.fiwka.ptmplace.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.fiwka.ptmplace.dto.request.TransportModeFilter;
import xyz.fiwka.ptmplace.dto.response.CityResponse;
import xyz.fiwka.ptmplace.entity.City;
import xyz.fiwka.ptmplace.entity.Route;
import xyz.fiwka.ptmplace.mapper.CityMapper;
import xyz.fiwka.ptmplace.repository.RouteRepository;
import xyz.fiwka.ptmplace.service.RouteService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final CityMapper cityMapper;
    private final Map<City, List<Route>> graph = new ConcurrentHashMap<>();

    @PostConstruct
    private void initializeGraph() {
        var allRoutes = routeRepository.findAll();

        for (var route : allRoutes) {
            graph.compute(route.getDepartureCity(), (key, value) -> {
                if (value == null)
                    value = new ArrayList<>();

                value.add(route);
                return value;
            });
        }
    }

    public void dfs(City from, City to, List<Route> subList, List<List<Route>> routes, Set<Long> visited, TransportModeFilter filter, LocalDateTime departure) {
        if (!graph.containsKey(from))
            return;

        if (!visited.add(from.getId()))
            return;

        for (var route : graph.get(from)) {
            if (route.getDeparture().isBefore(departure))
                continue;

            if ((filter.mix() != null && filter.mix()) || route.getMode() == filter.mode()) {
                var newSubList = new ArrayList<>(subList);
                newSubList.add(route);

                if (route.getArrivalCity().equals(to)) {
                    routes.add(newSubList);
                    continue;
                }

                dfs(route.getArrivalCity(), to, newSubList, routes, visited, filter, departure);
            }
        }
    }

    @Override
    @Cacheable("routes")
    public List<List<Route>> findRoutesBetween(CityResponse fromDto, CityResponse toDto, TransportModeFilter filter, LocalDateTime departure) {
        var from = cityMapper.toCity(fromDto);
        var to = cityMapper.toCity(toDto);

        if (!graph.containsKey(from))
            return List.of();

        List<List<Route>> routes = new ArrayList<>();
        Set<Long> visited = new HashSet<>();

        dfs(from, to, new ArrayList<>(), routes, visited, filter, departure);

        return routes;
    }

    @Override
    public Page<Route> listRoutes(Pageable pageable) {
        return routeRepository.findAll(pageable);
    }
}
