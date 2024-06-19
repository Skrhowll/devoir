package com.dev.school.service;

import com.dev.school.model.Airplane;
import com.dev.school.repository.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> findAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @Override
    public Optional<Airplane> findAirplaneById(Integer id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane saveAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane updateAirplane(Integer id, Airplane updatedAirplane) {
        return airplaneRepository.findById(id)
                .map(airplane -> prepareAndUpdateAirplane(airplane, updatedAirplane))
                .orElseGet(() -> prepareAndUpdateAirplane(new Airplane(), updatedAirplane));
    }

    @Override
    public void deleteAirplane(Integer id) {
        airplaneRepository.deleteById(id);
    }

    private Airplane prepareAndUpdateAirplane(Airplane toUpdate, Airplane source) {
        toUpdate.setName(source.getName());
        return airplaneRepository.save(toUpdate);
    }
}

