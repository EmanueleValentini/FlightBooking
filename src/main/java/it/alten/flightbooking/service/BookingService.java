package it.alten.flightbooking.service;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.Flight;
import it.alten.flightbooking.model.dto.BookingDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {

    boolean bookFlight(String flightNumber, Date flightDate, String passengerName, int numSeats);
    List<Booking> getFlightBookings(String flightNumber, Date flightDate);

    List<Booking> getPassengerBookings(String passengerName);

    boolean cancelBooking(Long id);

    List<Booking> findAll();

    Optional<Booking> findById(Long id);
    Booking save(BookingDto bookingDto);
}
