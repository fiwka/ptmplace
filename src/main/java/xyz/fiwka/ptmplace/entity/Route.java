package xyz.fiwka.ptmplace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDateTime;

@Data
@RelationshipProperties
@AllArgsConstructor
public class Route {

    @RelationshipId
    private Long id;

    @TargetNode
    private City city;

    private TransportMode transportMode;
    private LocalDateTime departure;
    private LocalDateTime arrival;
}
