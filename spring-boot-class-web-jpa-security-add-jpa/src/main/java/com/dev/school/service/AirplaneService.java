package com.dev.school.service;

import com.dev.school.model.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {
    List<Airplane> findAllAirplanes();

    Optional<Airplane> findAirplaneById(Integer id);

    Airplane saveAirplane(Airplane airplane);

    Airplane updateAirplane(Integer id, Airplane airplane);

    void deleteAirplane(Integer id);
}
