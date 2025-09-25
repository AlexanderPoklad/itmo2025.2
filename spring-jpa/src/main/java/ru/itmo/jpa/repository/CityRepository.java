package ru.itmo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.jpa.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}