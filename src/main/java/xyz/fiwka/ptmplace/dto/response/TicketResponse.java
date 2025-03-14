package xyz.fiwka.ptmplace.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import xyz.fiwka.ptmplace.entity.Ticket;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TicketResponse {

    private final Ticket.TicketKey key;
    private List<RouteResponse> routes;
    private String from;

    public TicketResponse withRoutes(List<RouteResponse> route) {
        setRoutes(route);
        return this;
    }

    public TicketResponse withFrom(String city) {
        setFrom(city);
        return this;
    }
}
