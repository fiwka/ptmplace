package xyz.fiwka.ptmplace.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record Path(City city, @JsonProperty("id") Long rid, LocalDateTime arrival, LocalDateTime departure, TransportMode transportMode) {
}
