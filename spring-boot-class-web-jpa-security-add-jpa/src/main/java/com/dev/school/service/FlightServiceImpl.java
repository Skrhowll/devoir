package com.dev.school.service;

import com.dev.school.model.Flight;
import com.dev.school.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findFlightByFlightNumber(String flightNumber) {
        return flightRepository.findById(flightNumber);
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(String flightNumber, Flight flight) {
        if (flightRepository.existsById(flightNumber)) {
            return flightRepository.save(flight);
        }
        return null;
    }

    @Override
    public void deleteFlight(String flightNumber) {
        flightRepository.deleteById(flightNumber);
    }

    @Override
    public List<Flight> findAllFlightsSortedByAirplane() {
        return flightRepository.findAll().stream()
                .sorted(Comparator.comparing(f -> f.getAirplane().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return flightRepository.findAll().stream()
                .filter(flight -> !flight.getDepartureTime().isBefore(startDate) && !flight.getArrivalTime().isAfter(endDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsByCityToday(String cityName) {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        return flightRepository.findAll().stream()
                .filter(flight -> (flight.getDepartureCity().getName().equals(cityName) || flight.getArrivalCity().getName().equals(cityName))
                        && !flight.getDepartureTime().isBefore(startOfDay) && !flight.getDepartureTime().isAfter(endOfDay))
                .collect(Collectors.toList());
    }
}
