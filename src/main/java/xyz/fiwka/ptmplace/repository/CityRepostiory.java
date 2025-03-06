package xyz.fiwka.ptmplace.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import xyz.fiwka.ptmplace.entity.City;
import xyz.fiwka.ptmplace.entity.TransportMode;

import java.time.LocalDateTime;
import java.util.List;

public interface CityRepostiory extends Neo4jRepository<City, Long> {

    @Query("""
            match s=shortestPath((src: City {name: $from})-[r:HAVE_ROUTE_TO*..5]->(dst: City {name: $to}))
            where all(rel in r where rel.transportMode = $mode and rel.departure >= $departure)
            unwind nodes(s) as cities
            return cities
    """)
    List<City> calculateShortestPathBetween(String from, String to, TransportMode mode, LocalDateTime departure);

    @Query("""
            match s=shortestPath((src: City {name: $from})-[r:HAVE_ROUTE_TO*..5]->(dst: City {name: $to}))
            where all(rel in r where rel.departure >= $departure)
            unwind nodes(s) as cities
            return cities
    """)
    List<City> calculateShortestPathBetween(String from, String to, LocalDateTime departure);
}
