package com.dev.school.controller;

import com.dev.school.model.City;
import com.dev.school.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.findAllCities();
    }

    // Obtenir une ville par ID
    @GetMapping("/{id}")
    public Optional<City> getCityById(@PathVariable int id) {
        return cityService.findCityById(id);
    }

    // Créer une nouvelle ville
    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    // Mettre à jour une ville
    @PutMapping("/{id}")
    public City updateCity(@PathVariable int id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    // Supprimer une ville
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
    }
}
