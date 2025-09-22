package ru.itmo.spring_database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itmo.spring_database.dao.CityDao;
import ru.itmo.spring_database.model.City;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {
    private final JdbcTemplate jdbcTemplate;

    public CityDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<City> cityRowMapper = (rs, rowNum) ->
            new City(
                    rs.getLong("id"),
                    rs.getString("code"),
                    rs.getString("name_ru"),
                    rs.getString("name_en"),
                    rs.getInt("population")
            );

    @Override
    public void save(City city) {
        jdbcTemplate.update(
                "INSERT INTO cities(code, name_ru, name_en, population) VALUES (?,?,?,?)",
                city.getCode(), city.getNameRu(), city.getNameEn(), city.getPopulation()
        );
    }

    @Override
    public List<City> findAll() {
        return jdbcTemplate.query("SELECT * FROM cities", cityRowMapper);
    }
}
