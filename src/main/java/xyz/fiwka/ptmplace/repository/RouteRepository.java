package xyz.fiwka.ptmplace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import xyz.fiwka.ptmplace.entity.Route;

public interface RouteRepository extends CrudRepository<Route, Long> {

    Page<Route> findAll(Pageable pageable);
}
