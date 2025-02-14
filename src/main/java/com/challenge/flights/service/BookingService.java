package com.challenge.flights.service;

import com.challenge.flights.exceptions.BookingAlreadyExistException;
import com.challenge.flights.exceptions.FlightFullException;
import com.challenge.flights.exceptions.FlightNotExistException;
import com.challenge.flights.model.Booking;
import com.challenge.flights.model.Flight;
import com.challenge.flights.persistence.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    FlightService flightService;

    @Autowired
    BookingRepository bookingRepository;

    public Booking getBooking(String bookingCode) {
        return bookingRepository.findByBookingCode(bookingCode);
    }

    public Booking createBooking(Booking booking) {

        Booking persistentBooking = bookingRepository.findBooking(booking.getBookingCode(), booking.getFlightNumber(), booking.getSeat());


        if (persistentBooking == null) {
            Flight flight = flightService.getFlight(booking.getFlightNumber());
            if (flight == null){
                throw new FlightNotExistException(booking);
            }
            if ( flight.getBookings() < flight.getSeats()) {
                flight.setBookings(flight.getBookings() + 1);
                flightService.saveFlight(flight);
                return bookingRepository.save(booking);

            } else {
                throw new FlightFullException(booking);
            }

        } else {
            throw new BookingAlreadyExistException(booking);
        }


    }

    @Transactional
    public void deleteBooking(String bookingCode) {
        Booking booking = bookingRepository.findByBookingCode(bookingCode);
        if (booking != null) {

            Flight flight = flightService.getFlight(booking.getFlightNumber());

            if (flight.getBookings() < flight.getSeats()) {
                flight.setBookings(flight.getBookings() - 1);
                flightService.saveFlight(flight);
            }
            bookingRepository.delete(booking);
        }
    }
}