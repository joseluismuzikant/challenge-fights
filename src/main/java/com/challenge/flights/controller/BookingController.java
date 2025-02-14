package com.challenge.flights.controller;

import com.challenge.flights.model.Booking;
import com.challenge.flights.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/bookings")
public class BookingController {


    @Autowired
    BookingService bookingService;

    @PostMapping("/booking")
    @ResponseBody
    public String createBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return "Booking created " + booking.getFlightNumber() + "for seat " + booking.getSeat();
    }

    @GetMapping("/booking/{bookingCode}")
    @ResponseBody
    public Booking getBooking(@PathVariable String bookingCode) {
        return bookingService.getBooking(bookingCode);
    }

    @DeleteMapping("/booking/{bookingCode}")
    @ResponseBody
    public void deleteBooking(@PathVariable String bookingCode) {
         bookingService.deleteBooking(bookingCode);
    }
}
