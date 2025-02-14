package com.challenge.flights.persistence;

import com.challenge.flights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository  extends JpaRepository<Flight, Long> {

    Flight findByFlightNumber( String  flightNumber);

    Flight findById(long id);
}
