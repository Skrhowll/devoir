package com.dev.school.repository;

import com.dev.school.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FlightRepositoryImpl {
    private ArrayList<Flight> flights = new ArrayList<>();

    public List<Flight> getAll() {
        return flights;
    }

    public void add(Flight flight) {
        flights.add(flight);
    }

    public void update(Flight flightParameter) {
        flights.forEach(flight -> {
            if (flightParameter.getFlightNumber().equals(flight.getFlightNumber())) {
                flight.setAirplane(flightParameter.getAirplane());
                flight.setDepartureCity(flightParameter.getDepartureCity());
                flight.setArrivalCity(flightParameter.getArrivalCity());
                flight.setDepartureTime(flightParameter.getDepartureTime());
                flight.setArrivalTime(flightParameter.getArrivalTime());
            }
        });
    }

    public void delete(String flightNumber) {
        flights.removeIf(flight -> flightNumber.equals(flight.getFlightNumber()));
    }

    public Optional<Flight> findByFlightNumber(String flightNumber) {
        return flights.stream()
                .filter(flight -> flightNumber.equals(flight.getFlightNumber()))
                .findFirst();
    }
}

