package com.dev.school.controller;

import com.dev.school.model.Flight;
import com.dev.school.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.findAllFlights();
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<Flight> getFlightByFlightNumber(@PathVariable String flightNumber) {
        return flightService.findFlightByFlightNumber(flightNumber)
                .map(flight -> ResponseEntity.ok().body(flight))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @PutMapping("/{flightNumber}")
    public Flight updateFlight(@PathVariable String flightNumber, @RequestBody Flight flight) {
        return flightService.updateFlight(flightNumber, flight);
    }

    @DeleteMapping("/{flightNumber}")
    public void deleteFlight(@PathVariable String flightNumber) {
        flightService.deleteFlight(flightNumber);
    }

    @GetMapping("/sorted-by-airplane")
    public List<Flight> getFlightsSortedByAirplane() {
        return flightService.findAllFlightsSortedByAirplane();
    }

    @GetMapping("/by-date-range")
    public List<Flight> getFlightsByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return flightService.findFlightsByDateRange(startDate, endDate);
    }

    @GetMapping("/by-city-today")
    public List<Flight> getFlightsByCityToday(@RequestParam String cityName) {
        return flightService.findFlightsByCityToday(cityName);
    }
}
