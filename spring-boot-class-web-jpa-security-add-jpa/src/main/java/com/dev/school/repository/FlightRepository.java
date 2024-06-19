package com.dev.school.repository;

import com.dev.school.model.City;
import com.dev.school.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByDepartureCity(City departureCity);
}
