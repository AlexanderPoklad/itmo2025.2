package ru.itmo.spring_database.dao;


import ru.itmo.spring_database.model.City;

import java.util.List;

public interface CityDao {
    void save(City city);
    List<City> findAll();
}
