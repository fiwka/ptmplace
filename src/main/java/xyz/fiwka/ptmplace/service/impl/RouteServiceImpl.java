package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xyz.fiwka.ptmplace.dto.request.TransportModeFilter;
import xyz.fiwka.ptmplace.dto.response.CityResponse;
import xyz.fiwka.ptmplace.entity.City;
import xyz.fiwka.ptmplace.exception.CityNotFoundException;
import xyz.fiwka.ptmplace.mapper.CityMapper;
import xyz.fiwka.ptmplace.repository.CityRepostiory;
import xyz.fiwka.ptmplace.service.RouteService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final CityRepostiory cityRepostiory;
    private final CityMapper cityMapper;

    @Override
    @Cacheable("routes")
    public List<CityResponse> findRouteBetween(Long from, Long to, TransportModeFilter filter, LocalDateTime departure) {
        var fromCity = cityRepostiory.findById(from)
                .orElseThrow(() -> new CityNotFoundException("City with id " + from + " not found."));
        var toCity = cityRepostiory.findById(to)
                .orElseThrow(() -> new CityNotFoundException("City with id " + to + " not found."));

        if (filter.mix()) {
            return cityRepostiory.calculateShortestPathBetween(fromCity.getName(), toCity.getName(), departure)
                    .stream()
                    .map(cityMapper::toCityResponseDto)
                    .toList();
        }

        return cityRepostiory.calculateShortestPathBetween(fromCity.getName(), toCity.getName(), filter.mode(), departure)
                .stream()
                .map(cityMapper::toCityResponseDto)
                .toList();
    }
}
