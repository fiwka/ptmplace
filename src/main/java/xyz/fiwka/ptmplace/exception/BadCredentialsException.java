package xyz.fiwka.ptmplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadCredentialsException extends ResponseStatusException {

    public BadCredentialsException(String reason) {
        super(HttpStatus.FORBIDDEN, reason);
    }
}
