package xyz.fiwka.ptmplace.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_generator")
    @SequenceGenerator(name="cities_generator", sequenceName = "cities_seq", allocationSize = 1)
    private Long id;
    private String name;
}
