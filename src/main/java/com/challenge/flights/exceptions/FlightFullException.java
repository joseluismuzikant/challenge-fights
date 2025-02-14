package com.challenge.flights.exceptions;

import com.challenge.flights.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FlightFullException extends RuntimeException{

    Booking booking;
}
