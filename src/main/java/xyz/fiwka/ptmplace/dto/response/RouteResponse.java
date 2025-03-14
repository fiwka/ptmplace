package xyz.fiwka.ptmplace.dto.response;

import xyz.fiwka.ptmplace.entity.TransportMode;

import java.time.LocalDateTime;

public record RouteResponse(String to, LocalDateTime arrival, LocalDateTime departure, TransportMode transportMode) {
}
