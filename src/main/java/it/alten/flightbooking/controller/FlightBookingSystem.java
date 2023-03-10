package it.alten.flightbooking.controller;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class FlightBookingSystem implements BookingController {
    @Override
    public ResponseEntity<Booking> save(BookingDto bookingDto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Booking>> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Booking>> findAll() {
        return null;
    }
}
