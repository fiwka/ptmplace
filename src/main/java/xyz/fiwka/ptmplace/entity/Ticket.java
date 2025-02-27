package xyz.fiwka.ptmplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {

    @EmbeddedId
    private TicketKey key;
    @ManyToOne
    @MapsId("ownerId")
    private User owner;
    @ManyToOne
    @MapsId("routeId")
    private Route route;
    private int place;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TicketKey implements Serializable {

        private Long ownerId;
        private Long routeId;
    }
}
