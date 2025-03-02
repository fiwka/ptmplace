package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import xyz.fiwka.ptmplace.dto.request.AuthenticationRequest;
import xyz.fiwka.ptmplace.dto.request.RefreshTokenRequest;
import xyz.fiwka.ptmplace.dto.response.TokenResponse;
import xyz.fiwka.ptmplace.exception.BadCredentialsException;
import xyz.fiwka.ptmplace.exception.TokenInvalidException;
import xyz.fiwka.ptmplace.provider.JwtTokenProvider;
import xyz.fiwka.ptmplace.repository.UserRepository;
import xyz.fiwka.ptmplace.service.AuthenticationService;
import xyz.fiwka.ptmplace.util.JwtUtil;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtUtil jwtUtil;

    @Override
    public TokenResponse authenticate(AuthenticationRequest authenticationRequest) {
        try {
            var user = userRepository.findByEmail(authenticationRequest.email())
                    .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.email(),
                    authenticationRequest.password()
            ));

            return jwtTokenProvider.generateTokens(user.getEmail());
        } catch (AuthenticationException exception) {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    public TokenResponse refresh(RefreshTokenRequest refreshTokenRequest) {
        var refreshToken = refreshTokenRequest.refreshToken();

        if (!jwtUtil.isRefreshToken(refreshToken))
            throw new TokenInvalidException(HttpStatus.BAD_REQUEST, "Refresh token required");

        var email = jwtUtil.getEmail(refreshToken);
        userRepository.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        return jwtTokenProvider.generateTokens(email);
    }
}
