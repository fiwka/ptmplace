package xyz.fiwka.ptmplace.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import xyz.fiwka.ptmplace.dto.response.TicketResponse;
import xyz.fiwka.ptmplace.entity.Ticket;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {

    TicketResponse toTicketResponseDto(Ticket ticket);
}
