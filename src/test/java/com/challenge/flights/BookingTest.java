package com.challenge.flights;

import com.challenge.flights.exceptions.BookingAlreadyExistException;
import com.challenge.flights.model.Booking;
import com.challenge.flights.model.Flight;
import com.challenge.flights.service.BookingService;
import com.challenge.flights.service.FlightService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookingTest {

    @Autowired
    BookingService bookingService;

    @Autowired
    FlightService flightService;

    Flight flight;

    String flightNumber = "AF296Q";

    String bookingCode = "B8XYZ6";

    int seats = 100;

    @BeforeEach
    public void setUp() {

        flight = Flight.builder().flightNumber(flightNumber).seats(seats).build();
        flight = flightService.saveFlight(flight);

    }

    @AfterEach
    public void tearDown() {
        bookingService.deleteBooking(bookingCode);
        flightService.deleteFlight(flight);
    }


    @Test
    public void createBooking() {


        int seat = 21;

        Booking booking = Booking.builder().bookingCode(bookingCode).flightNumber(flightNumber).seat(seat).build();

        bookingService.createBooking(booking);

        //Then we get a new booking and
        flight = flightService.getFlight(flightNumber);
        booking = bookingService.getBooking(bookingCode);
        assertEquals(flight.getFlightNumber(), flightNumber);
        assertEquals(flight.getBookings(), 1);
        assertTrue(flight.getBookings() < flight.getSeats());
        assertEquals(booking.getBookingCode(), bookingCode);
        assertEquals(booking.getFlightNumber(), flightNumber);
        assertEquals(booking.getSeat(), 21);


    }

    @Test
    public void createAlreadyExistingBooking() {

        Booking booking = Booking.builder().bookingCode(bookingCode).flightNumber(flightNumber).seat(21).build();

        bookingService.createBooking(booking);

        assertThrows(BookingAlreadyExistException.class, () -> {
            bookingService.createBooking(booking);
        });

    }

    @Test
    public void deleteBooking() {

        String bookingCode = "B8XYZ6";

        int seat = 21;

        Booking booking = Booking.builder().bookingCode(bookingCode).flightNumber(flightNumber).seat(seat).build();

        bookingService.createBooking(booking);

        bookingService.deleteBooking(booking.getBookingCode());

        flight = flightService.getFlight(flightNumber);

        assertEquals(flight.getFlightNumber(), flightNumber);
        assertEquals(flight.getBookings(), 0);


    }
}
