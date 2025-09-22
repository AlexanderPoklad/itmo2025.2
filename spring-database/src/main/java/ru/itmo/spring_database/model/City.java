package ru.itmo.spring_database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Long id;
    private String code;
    private String nameRu;
    private String nameEn;
    private int population;
}