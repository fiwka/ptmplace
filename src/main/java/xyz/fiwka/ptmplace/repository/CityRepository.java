package xyz.fiwka.ptmplace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import xyz.fiwka.ptmplace.entity.City;

public interface CityRepository extends CrudRepository<City, Long> {

    Page<City> findAll(Pageable pageable);
}
