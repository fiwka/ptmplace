package xyz.fiwka.ptmplace.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routes_generator")
    @SequenceGenerator(name="routes_generator", sequenceName = "routes_seq", allocationSize = 1)
    private Long id;
    private TransportMode mode;
    @ManyToOne
    private City departureCity;
    @ManyToOne
    private City arrivalCity;
    private LocalDateTime departure;
    private LocalDateTime arrival;
}
