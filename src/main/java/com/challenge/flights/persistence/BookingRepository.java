package com.challenge.flights.persistence;

import com.challenge.flights.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findByBookingCode(String bookingCode);

    @Query("SELECT b FROM Booking b WHERE b.bookingCode = ?1 OR (b.flightNumber = ?2 AND b.seat = ?3)")
    Booking findBooking(String bookingCode, String flightNumber, int seat);

}
