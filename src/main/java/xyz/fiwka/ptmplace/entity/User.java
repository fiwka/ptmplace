package xyz.fiwka.ptmplace.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_generator")
    @SequenceGenerator(name="users_generator", sequenceName = "users_seq", allocationSize = 1)
    private Long id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
    private String password;

}
