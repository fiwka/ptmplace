package xyz.fiwka.ptmplace.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import xyz.fiwka.ptmplace.dto.request.CityRequest;
import xyz.fiwka.ptmplace.dto.response.CityResponse;
import xyz.fiwka.ptmplace.entity.City;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {

    CityResponse toCityResponseDto(City city);
    City toCity(CityRequest cityRequest);
}
