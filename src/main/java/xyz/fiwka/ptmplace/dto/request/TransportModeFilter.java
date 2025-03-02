package xyz.fiwka.ptmplace.dto.request;

import xyz.fiwka.ptmplace.entity.TransportMode;

public record TransportModeFilter(
        TransportMode mode,
        Boolean mix
) {
}
