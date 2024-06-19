package com.dev.school.service;

import com.dev.school.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> findAllFlights();

    Optional<Flight> findFlightByFlightNumber(String flightNumber);

    Flight saveFlight(Flight flight);

    Flight updateFlight(String flightNumber, Flight flight);

    void deleteFlight(String flightNumber);

    List<Flight> findAllFlightsSortedByAirplane();

    List<Flight> findFlightsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    List<Flight> findFlightsByCityToday(String cityName);
}
