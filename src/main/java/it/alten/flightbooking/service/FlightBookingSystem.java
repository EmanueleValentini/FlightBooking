package it.alten.flightbooking.service;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.Flight;
import it.alten.flightbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightBookingSystem implements BookingService{

    @Autowired
    BookingRepository repo;

    @Autowired
    FlightRepository repoFlight;

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
        return repo.findBookingsByFlightNumberAndFlightDate(flightNumber,flightDate);
    }

    public int getAvailableSeats(String flightNumber, Date flightDate){
        return repoFlight.findByFlightNumberAndFlightDate(flightNumber,flightDate).getSeats();
    }

    public List<Flight> getFlights(String fromAirport, String toAirport, Date date){
        return repoFlight.findByFromAirportAndToAirportAndDate(fromAirport,toAirport,date);
    }

    @Override
    public List<Booking> getPassengerBookings(String passengerName) {
        return repo.findByPassengerName(passengerName);
    }

    @Override
    public boolean cancelBooking(Long id) {
        if(repo.findById(id).isPresent()){
            return true;
        }
        return false;
    }
}
