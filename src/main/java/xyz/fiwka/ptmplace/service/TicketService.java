package xyz.fiwka.ptmplace.service;

import xyz.fiwka.ptmplace.entity.Route;
import xyz.fiwka.ptmplace.entity.User;

public interface TicketService {

    void bookTicket(User owner, Route route, int place);
}
