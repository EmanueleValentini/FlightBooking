package it.alten.flightbooking.controller;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/bookings")
public interface BookingController {
    @PostMapping()
    ResponseEntity<Booking> save(@RequestBody BookingDto bookingDto);

    @GetMapping("/{id}")
    ResponseEntity<Optional<Booking>> findById(@PathVariable("id") Long id);

    @GetMapping()
    ResponseEntity<List<Booking>> findAll();
}
