package xyz.fiwka.ptmplace.service;

import xyz.fiwka.ptmplace.dto.request.TransportModeFilter;
import xyz.fiwka.ptmplace.dto.response.CityResponse;
import xyz.fiwka.ptmplace.entity.Path;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteService {

    List<Path> findRouteBetween(Long from, Long to, TransportModeFilter filter, LocalDateTime departure);
}
