package com.challenge.flights.controller;

import com.challenge.flights.model.Flight;
import com.challenge.flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;


    @GetMapping("/flight/{flightNumber}")
    @ResponseBody
    public Flight getFlight(@PathVariable String flightNumber) {
        return flightService.getFlight(flightNumber);
    }

    @PostMapping("/flight")
    @ResponseBody
    public String createFlight(@RequestBody Flight flight) {
        flightService.saveFlight(flight);
        return "Flight created " + flight.getFlightNumber();
    }

}
