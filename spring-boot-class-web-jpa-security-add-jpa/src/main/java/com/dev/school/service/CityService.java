package com.dev.school.service;

import com.dev.school.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> findAllCities();

    Optional<City> findCityById(Integer id);

    City saveCity(City city);

    City updateCity(Integer id, City city);

    void deleteCity(Integer id);
}

