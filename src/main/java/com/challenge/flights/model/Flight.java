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
public class Flight {

    public Flight() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int seats;

    private String flightNumber;

    private int bookings;

}
