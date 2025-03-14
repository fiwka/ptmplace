package xyz.fiwka.ptmplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import xyz.fiwka.ptmplace.dto.request.TicketRequest;
import xyz.fiwka.ptmplace.dto.response.TicketResponse;
import xyz.fiwka.ptmplace.exception.UserNotFoundException;
import xyz.fiwka.ptmplace.service.TicketService;
import xyz.fiwka.ptmplace.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<TicketResponse>> listTickets(Pageable pageable) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.findUser(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return ResponseEntity.ok(ticketService.listTickets(user, pageable));
    }

    @PostMapping
    public ResponseEntity<List<TicketResponse>> bookTicket(@RequestBody TicketRequest ticketRequest) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.findUser(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return ResponseEntity.ok(ticketService.bookTicket(user, ticketRequest));
    }

    @DeleteMapping
    public ResponseEntity<String> cancelTicket(@RequestBody TicketRequest ticketRequest) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.findUser(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        ticketService.cancelTicket(user, ticketRequest);

        return ResponseEntity.ok("{\"status\":\"ok\"}");
    }
}
