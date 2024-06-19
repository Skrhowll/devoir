package com.dev.school.repository;

import com.dev.school.model.Airplane;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AirplaneRepositoryImpl {
    private final List<Airplane> airplanes = new ArrayList<>();

    public List<Airplane> findAll() {
        return new ArrayList<>(airplanes);
    }

    public void add(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void update(Airplane airplaneParameter) {
        airplanes.stream()
                .filter(airplane -> airplaneParameter.getId().equals(airplane.getId()))
                .findFirst()
                .ifPresent(airplane -> airplane.setName(airplaneParameter.getName()));
    }

    public void delete(Integer id) {
        airplanes.removeIf(airplane -> id.equals(airplane.getId()));
    }

    public Optional<Airplane> findById(Integer id) {
        return airplanes.stream()
                .filter(airplane -> id.equals(airplane.getId()))
                .findFirst();
    }
}
