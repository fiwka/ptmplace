package xyz.fiwka.ptmplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.fiwka.ptmplace.dto.request.CityRequest;
import xyz.fiwka.ptmplace.dto.response.CityResponse;

import java.util.Optional;

public interface CityService {

    Page<CityResponse> listCities(Pageable pageable);
    Optional<CityResponse> findCity(long id);
}
