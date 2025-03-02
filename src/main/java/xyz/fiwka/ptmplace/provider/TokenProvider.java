package xyz.fiwka.ptmplace.provider;

import xyz.fiwka.ptmplace.dto.response.TokenResponse;

public interface TokenProvider {

    TokenResponse generateTokens(String email);
}
