package xyz.fiwka.ptmplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import xyz.fiwka.ptmplace.dto.request.TransportModeFilter;
import xyz.fiwka.ptmplace.entity.Route;
import xyz.fiwka.ptmplace.exception.CityNotFoundException;
import xyz.fiwka.ptmplace.service.CityService;
import xyz.fiwka.ptmplace.service.RouteService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/route")
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<Page<Route>> listRoutes(Pageable pageable) {
        return ResponseEntity.ok(routeService.listRoutes(pageable));
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<List<List<Route>>> findRoutesBetween(@PathVariable("from") Long fromId, @PathVariable("to") Long toId, TransportModeFilter filter, @RequestParam("departure") Long departure) {
        var from = cityService.findCity(fromId)
                .orElseThrow(() -> new CityNotFoundException("City with id " + fromId + " not found."));
        var to = cityService.findCity(toId)
                .orElseThrow(() -> new CityNotFoundException("City with id " + toId + " not found."));
        var departureTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(departure), ZoneId.systemDefault());

        return ResponseEntity.ok(routeService.findRoutesBetween(from, to, filter, departureTime));
    }
}
