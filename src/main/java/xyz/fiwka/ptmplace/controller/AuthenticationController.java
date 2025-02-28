package xyz.fiwka.ptmplace.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fiwka.ptmplace.dto.request.AuthenticationRequest;
import xyz.fiwka.ptmplace.dto.request.RefreshTokenRequest;
import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.dto.response.TokenResponseDto;
import xyz.fiwka.ptmplace.dto.response.UserResponseDto;
import xyz.fiwka.ptmplace.service.AuthenticationService;
import xyz.fiwka.ptmplace.service.UserService;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserFieldsRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponseDto> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponseDto> refresh(@Valid @RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(authenticationService.refresh(request));
    }
}
