package xyz.fiwka.ptmplace.service;

import xyz.fiwka.ptmplace.dto.request.AuthenticationRequest;
import xyz.fiwka.ptmplace.dto.request.RefreshTokenRequest;
import xyz.fiwka.ptmplace.dto.response.TokenResponseDto;

public interface AuthenticationService {

    TokenResponseDto authenticate(AuthenticationRequest authenticationRequest);
    TokenResponseDto refresh(RefreshTokenRequest refreshTokenRequest);
}
