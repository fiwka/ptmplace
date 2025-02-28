package xyz.fiwka.ptmplace.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class TokenInvalidException extends ResponseStatusException {

    public TokenInvalidException(HttpStatusCode code, String reason) {
        super(code, reason);
    }
}
