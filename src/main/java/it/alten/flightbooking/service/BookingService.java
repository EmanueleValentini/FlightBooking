package it.alten.flightbooking.service;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.Flight;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<Booking> findBookingsByFlightNumberAndFlightDate(String flightNumber, Date flightDate);

    Flight findByFlightNumberAndFlightDate(String flightNumber, Date flightDate);

    List<Flight> findByTakeOffAirportAndLandingAirportAndFlightDate
            (String takeOffAirport, String depatureAirport, Date flightDate);
}
