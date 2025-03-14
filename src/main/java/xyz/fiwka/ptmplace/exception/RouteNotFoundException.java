package xyz.fiwka.ptmplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RouteNotFoundException extends ResponseStatusException {

    public RouteNotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
