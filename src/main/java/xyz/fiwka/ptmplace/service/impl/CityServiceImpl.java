package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.fiwka.ptmplace.dto.request.CityRequest;
import xyz.fiwka.ptmplace.dto.response.CityResponse;
import xyz.fiwka.ptmplace.mapper.CityMapper;
import xyz.fiwka.ptmplace.repository.CityRepository;
import xyz.fiwka.ptmplace.service.CityService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public Page<CityResponse> listCities(Pageable pageable) {
        return cityRepository.findAll(pageable).map(cityMapper::toCityResponseDto);
    }

    @Override
    public CityResponse createCity(CityRequest cityRequest) {
        return cityMapper.toCityResponseDto(cityRepository.save(cityMapper.toCity(cityRequest)));
    }

    @Override
    public Optional<CityResponse> findCity(long id) {
        return cityRepository.findById(id).map(cityMapper::toCityResponseDto);
    }
}
