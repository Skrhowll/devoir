package com.dev.school.service;

import com.dev.school.model.City;
import com.dev.school.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findCityById(Integer id) {
        return cityRepository.findById(id);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Integer id, City updatedCity) {
        return cityRepository.findById(id)
                .map(city -> {
                    city.setName(updatedCity.getName());
                    return cityRepository.save(city);
                })
                .orElseGet(() -> {
                    updatedCity.setId(id);
                    return cityRepository.save(updatedCity);
                });
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }
}
