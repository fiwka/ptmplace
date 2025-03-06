package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.neo4j.core.Neo4jOperations;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.repository.query.QueryFragmentsAndParameters;
import org.springframework.stereotype.Service;
import xyz.fiwka.ptmplace.dto.request.TransportModeFilter;
import xyz.fiwka.ptmplace.entity.City;
import xyz.fiwka.ptmplace.exception.CityNotFoundException;
import xyz.fiwka.ptmplace.repository.CityRepostiory;
import xyz.fiwka.ptmplace.service.RouteService;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final CityRepostiory cityRepostiory;

    @Override
    @Cacheable("routes")
    public List<City> findRouteBetween(Long from, Long to, TransportModeFilter filter, LocalDateTime departure) {
        var fromCity = cityRepostiory.findById(from)
                .orElseThrow(() -> new CityNotFoundException("City with id " + from + " not found."));
        var toCity = cityRepostiory.findById(to)
                .orElseThrow(() -> new CityNotFoundException("City with id " + to + " not found."));

        if (filter.mix()) {
            return cityRepostiory.calculateShortestPathBetween(fromCity.getName(), toCity.getName(), departure);
        }

        return cityRepostiory.calculateShortestPathBetween(fromCity.getName(), toCity.getName(), filter.mode(), departure);
    }
}
