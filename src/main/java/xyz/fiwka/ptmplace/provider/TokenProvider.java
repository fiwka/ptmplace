package xyz.fiwka.ptmplace.provider;

import xyz.fiwka.ptmplace.dto.response.TokenResponseDto;

public interface TokenProvider {

    TokenResponseDto generateTokens(String email);
}
