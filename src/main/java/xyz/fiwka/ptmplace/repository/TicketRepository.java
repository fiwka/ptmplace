package xyz.fiwka.ptmplace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import xyz.fiwka.ptmplace.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Ticket.TicketKey> {

    boolean existsByKeyOwnerIdAndKeyRouteId(Long ownerId, Long routeId);
    Page<Ticket> findAllByKeyOwnerId(Long ownerId, Pageable pageable);
}
