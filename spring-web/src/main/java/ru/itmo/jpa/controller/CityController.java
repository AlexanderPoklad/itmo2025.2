package ru.itmo.jpa.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itmo.jpa.dto.CityDto;
import ru.itmo.jpa.service.CityService;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto create(@Valid @RequestBody CityDto dto) {
        return cityService.create(dto);
    }

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public CityDto getById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable Long id, @Valid @RequestBody CityDto dto) {
        return cityService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }
}