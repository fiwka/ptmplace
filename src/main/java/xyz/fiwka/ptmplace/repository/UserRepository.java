package xyz.fiwka.ptmplace.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.fiwka.ptmplace.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
