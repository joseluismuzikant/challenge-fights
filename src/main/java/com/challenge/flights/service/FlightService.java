package com.challenge.flights.service;

import com.challenge.flights.model.Flight;
import com.challenge.flights.persistence.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository ;

    public Flight getFlight(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }


    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Flight flight) {
          flightRepository.delete(flight);
    }
}
