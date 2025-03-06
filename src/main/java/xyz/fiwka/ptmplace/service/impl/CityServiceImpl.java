package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.fiwka.ptmplace.dto.response.CityResponse;
import xyz.fiwka.ptmplace.mapper.CityMapper;
import xyz.fiwka.ptmplace.repository.CityRepostiory;
import xyz.fiwka.ptmplace.service.CityService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;
    private final CityRepostiory cityRepostiory;

    @Override
    public Page<CityResponse> listCities(Pageable pageable) {
        return cityRepostiory.findAll(pageable).map(cityMapper::toCityResponseDto);
    }

    @Override
    public Optional<CityResponse> findCity(long id) {
        return cityRepostiory.findById(id).map(cityMapper::toCityResponseDto);
    }
}
