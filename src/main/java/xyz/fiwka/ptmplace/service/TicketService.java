package xyz.fiwka.ptmplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.fiwka.ptmplace.dto.request.TicketRequest;
import xyz.fiwka.ptmplace.dto.response.TicketResponse;
import xyz.fiwka.ptmplace.dto.response.UserResponse;

import java.util.List;

public interface TicketService {

    List<TicketResponse> bookTicket(UserResponse owner, TicketRequest ticketRequest);
    void cancelTicket(UserResponse owner, TicketRequest ticketRequest);
    Page<TicketResponse> listTickets(UserResponse owner, Pageable pageable);
}
