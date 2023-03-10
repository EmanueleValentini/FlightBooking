package it.alten.flightbooking.service;

import it.alten.flightbooking.model.Booking;
import it.alten.flightbooking.model.Flight;
import it.alten.flightbooking.model.dto.BookingDto;
import it.alten.flightbooking.repository.BookingRepository;
import it.alten.flightbooking.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightBookingSystem implements BookingService{

    @Autowired
    BookingRepository repo;

    FlightRepository flightRepo = new FlightRepository();


    @Override
    public boolean bookFlight(String flightNumber, Date flightDate, String passengerName, int numSeats) {
        if(!repo.findBookingsByFlightNumberAndFlightDate(flightNumber,flightDate).isEmpty()  &&
            !repo.findByPassengerName(passengerName).isEmpty()   &&
                flightRepo.findByFlightNumber(flightNumber).getSeats()>=numSeats){
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getFlightBookings(String flightNumber, Date flightDate) {
        return repo.findBookingsByFlightNumberAndFlightDate(flightNumber,flightDate);
    }

    public int getAvailableSeats(String flightNumber, Date flightDate){
        return flightRepo.findByFlightNumberAndFlightDate(flightNumber,flightDate).getSeats();
    }

    public List<Flight> getFlights(String fromAirport, String toAirport, Date date){
        return flightRepo.findByFromAirportAndToAirportAndDate(fromAirport,toAirport,date);
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

    @Override
    public List<Booking> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public Booking save(BookingDto bookingDto) {
        ModelMapper modelMapper = new ModelMapper();
        return repo.save(modelMapper.map(bookingDto, Booking.class));
    }
}
