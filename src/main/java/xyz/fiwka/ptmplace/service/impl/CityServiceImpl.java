package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("citesList")
    public Page<CityResponse> listCities(Pageable pageable) {
        return cityRepostiory.findAll(pageable).map(cityMapper::toCityResponseDto);
    }

    @Override
    @Cacheable("cityByName")
    public Optional<CityResponse> findCity(String name) {
        return cityRepostiory.findByNameIgnoreCase(name).map(cityMapper::toCityResponseDto);
    }
}
