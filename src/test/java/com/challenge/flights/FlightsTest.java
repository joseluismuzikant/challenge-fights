package com.challenge.flights;

import com.challenge.flights.model.Flight;
import com.challenge.flights.service.FlightService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FlightsTest {

    @Autowired
    FlightService flightService ;

    //Given a flight with reservation code AF296Q
    String flightNumber = "AF296Q";
    int seats = 100;
    Flight flight ;

    @BeforeEach
    public void setUp() {

        flight = Flight.builder().flightNumber(flightNumber).seats(seats).build();
        flight = flightService.saveFlight(flight);

    }
    @AfterEach
    public void tearDown() {
        flightService.deleteFlight(flight);
    }


    @Test
    public void retrieveAvailableFlights(){

        // When I call the flight service whith that code

         flight = flightService.getFlight(flightNumber);

        //Then we get the flight XXYYZZ

        assertEquals(flight.getFlightNumber(), flightNumber);

        flightService.deleteFlight(flight);

    }
}
