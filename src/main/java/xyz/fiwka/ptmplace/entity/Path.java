package xyz.fiwka.ptmplace.entity;

import java.time.LocalDateTime;

public record Path(City city, LocalDateTime arrival, LocalDateTime departure, TransportMode transportMode) {
}
