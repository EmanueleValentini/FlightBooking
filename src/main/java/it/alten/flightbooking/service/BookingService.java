package it.alten.flightbooking.service;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.Flight;

import java.util.Date;
import java.util.List;

public interface BookingService {

    boolean bookFlight(String flightNumber, Date flightDate, String passengerName, int numSeats);
    List<Booking> getFlightBookings(String flightNumber, Date flightDate);

    List<Booking> getPassengerBooklings(String passengerName);

    boolean cancelBooking(Long id);
}
