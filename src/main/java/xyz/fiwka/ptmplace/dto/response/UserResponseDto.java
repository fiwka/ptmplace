package xyz.fiwka.ptmplace.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import xyz.fiwka.ptmplace.security.Role;

import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record UserResponseDto(
        Long id,
        String lastName,
        String firstName,
        String email,
        String phoneNumber,
        Set<Role> roles
) {
}
