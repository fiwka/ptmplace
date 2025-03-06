package xyz.fiwka.ptmplace.service;

import xyz.fiwka.ptmplace.dto.request.TransportModeFilter;
import xyz.fiwka.ptmplace.entity.City;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteService {

    List<City> findRouteBetween(Long from, Long to, TransportModeFilter filter, LocalDateTime departure);
}
