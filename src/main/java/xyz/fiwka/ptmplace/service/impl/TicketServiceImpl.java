package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.fiwka.ptmplace.entity.Route;
import xyz.fiwka.ptmplace.entity.User;
import xyz.fiwka.ptmplace.repository.TicketRepository;
import xyz.fiwka.ptmplace.service.TicketService;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public void bookTicket(User owner, Route route, int place) {

    }
}
