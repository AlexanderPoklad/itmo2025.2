package ru.itmo.jpa.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.jpa.dto.CityDto;
import ru.itmo.jpa.model.City;
import ru.itmo.jpa.model.Country;
import ru.itmo.jpa.repository.CityRepository;
import ru.itmo.jpa.repository.CountryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public CityDto create(CityDto dto) {
        Country country = countryRepository.findById(dto.getCountryId())
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));

        City city = new City();
        city.setCode(dto.getCode());
        city.setNameRu(dto.getNameRu());
        city.setNameEn(dto.getNameEn());
        city.setPopulation(dto.getPopulation());
        city.setCountry(country);

        return toDto(cityRepository.save(city));
    }

    @Transactional(readOnly = true)
    public List<CityDto> findAll() {
        return cityRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public CityDto findById(Long id) {
        return cityRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));
    }

    @Transactional
    public CityDto update(Long id, CityDto dto) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));

        city.setCode(dto.getCode());
        city.setNameRu(dto.getNameRu());
        city.setNameEn(dto.getNameEn());
        city.setPopulation(dto.getPopulation());

        if (!city.getCountry().getId().equals(dto.getCountryId())) {
            Country country = countryRepository.findById(dto.getCountryId())
                    .orElseThrow(() -> new EntityNotFoundException("Country not found"));
            city.setCountry(country);
        }

        return toDto(cityRepository.save(city));
    }

    @Transactional
    public void delete(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new EntityNotFoundException("City not found");
        }
        cityRepository.deleteById(id);
    }

    private CityDto toDto(City city) {
        return new CityDto(
                city.getId(),
                city.getCode(),
                city.getNameRu(),
                city.getNameEn(),
                city.getPopulation(),
                city.getCountry().getId()
        );
    }
}