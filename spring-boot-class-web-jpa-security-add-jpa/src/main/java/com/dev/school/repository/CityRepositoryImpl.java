package com.dev.school.repository;

import com.dev.school.model.City;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CityRepositoryImpl {
    private ArrayList<City> cities = new ArrayList<>();

    public List<City> getAll() {
        return cities;
    }

    public void add(City city) {
        cities.add(city);
    }

    public void update(City cityParameter) {
        cities.forEach(city -> {
            if (cityParameter.getId().equals(city.getId())) {
                city.setName(cityParameter.getName());
            }
        });
    }

    public void delete(Integer id) {
        cities.removeIf(city -> id.equals(city.getId()));
    }

    public Optional<City> findById(Integer id) {
        return cities.stream()
                .filter(city -> id.equals(city.getId()))
                .findFirst();
    }
}

