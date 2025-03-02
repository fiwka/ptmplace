package xyz.fiwka.ptmplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.fiwka.ptmplace.dto.request.TransportModeFilter;
import xyz.fiwka.ptmplace.dto.response.CityResponse;
import xyz.fiwka.ptmplace.entity.Route;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteService {

    List<List<Route>> findRoutesBetween(CityResponse from, CityResponse to, TransportModeFilter filter, LocalDateTime departure);
    Page<Route> listRoutes(Pageable pageable);
}
