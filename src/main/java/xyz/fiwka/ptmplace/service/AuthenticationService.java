package xyz.fiwka.ptmplace.service;

import xyz.fiwka.ptmplace.dto.request.AuthenticationRequest;
import xyz.fiwka.ptmplace.dto.request.RefreshTokenRequest;
import xyz.fiwka.ptmplace.dto.response.TokenResponse;

public interface AuthenticationService {

    TokenResponse authenticate(AuthenticationRequest authenticationRequest);
    TokenResponse refresh(RefreshTokenRequest refreshTokenRequest);
}
