package ru.itmo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.jpa.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    boolean existsByCode(String code);
}