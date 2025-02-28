package xyz.fiwka.ptmplace.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TokenResponseDto(
        String accessToken,
        long accessTokenExpiration,
        String refreshToken,
        long refreshTokenExpiration
) { }
