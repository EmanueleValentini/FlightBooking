package it.alten.flightbooking.controller;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.dto.BookingDto;
import it.alten.flightbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class FlightBookingControllerImpl implements FlightBookingController{

    @Autowired
    private BookingService bookingService;

    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Booking> save(String flightNumber, Date date, String passengerName, int numSeats) {
        bookingService.bookFlight(flightNumber,date,passengerName,numSeats);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Booking>> findById(@PathVariable("id") Long id) {
        Optional<Booking> bookingFound = bookingService.findById(id);
        return new ResponseEntity<>(bookingFound,HttpStatus.FOUND);
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<Booking>> findAll() {
        List<Booking> bookings = bookingService.findAll();
        return new ResponseEntity<>(bookings,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Booking>> deleteById(@PathVariable("id") Long id){
        bookingService.cancelBooking(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<Booking> save(@RequestBody  BookingDto bookingDto) {
        Booking bookingSaved=bookingService.save(bookingDto);
        return new ResponseEntity<>(bookingSaved, HttpStatus.CREATED);
    }
}
