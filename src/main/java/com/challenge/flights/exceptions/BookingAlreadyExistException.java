package com.challenge.flights.exceptions;

import com.challenge.flights.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookingAlreadyExistException extends RuntimeException{

    Booking booking;
}
