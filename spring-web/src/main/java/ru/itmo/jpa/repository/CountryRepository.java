package ru.itmo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.jpa.model.Country;

@Repository
@Transactional(readOnly = true)
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Override
    @Transactional
    <S extends Country> S save(S entity);

    @Override
    @Transactional
    void deleteById(Long id);
}