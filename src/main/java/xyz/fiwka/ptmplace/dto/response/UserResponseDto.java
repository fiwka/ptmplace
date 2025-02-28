package xyz.fiwka.ptmplace.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record UserResponseDto(
        Long id,
        String lastName,
        String firstName,
        String email,
        String phoneNumber
) {
}
