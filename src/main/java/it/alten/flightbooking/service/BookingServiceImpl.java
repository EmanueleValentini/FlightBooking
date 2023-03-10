package it.alten.flightbooking.service;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository repo;

    @Override
    public boolean bookFlight(String flightNumber, Date flightDate, String passengerName, int numSeats) {
        if(!repo.findBookingsByFlightNumberAndFlightDate(flightNumber,flightDate).isEmpty()  &&
            !repo.findByPassengerName(passengerName).isEmpty()   &&
                !repoFlight.findByFlightNumber(flightNumber).getNumSeats>numSeats){
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getFlightBookings(String flightNumber, Date flightDate) {
        return null;
    }

    @Override
    public List<Booking> getPassengerBooklings(String passengerName) {
        return null;
    }

    @Override
    public boolean cancelBooking(Long id) {
        return false;
    }
}
