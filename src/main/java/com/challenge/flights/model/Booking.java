package com.challenge.flights.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Booking {

    public Booking() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String bookingCode;

    private int seat;

    private String flightNumber;

}
