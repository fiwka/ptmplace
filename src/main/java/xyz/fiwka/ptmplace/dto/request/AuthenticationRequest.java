package xyz.fiwka.ptmplace.dto.request;

import jakarta.validation.constraints.Email;

public record AuthenticationRequest(@Email String email, String password) {
}
