package ru.itmo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.jpa.model.City;

@Repository
@Transactional(readOnly = true)
public interface CityRepository extends JpaRepository<City, Long> {

    @Override
    @Transactional
    <S extends City> S save(S entity);

    @Override
    @Transactional
    void deleteById(Long id);
}