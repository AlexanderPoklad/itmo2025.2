package ru.itmo.jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private Long id;

    @NotBlank
    private String code;

    @NotBlank
    private String nameRu;

    @NotBlank
    private String nameEn;

    @Min(1)
    private int population;

    @NotNull
    private Long countryId;
}