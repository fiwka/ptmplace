package xyz.fiwka.ptmplace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import xyz.fiwka.ptmplace.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    Page<Ticket> findAllByOwnerId(Long ownerId, Pageable pageable);
}
