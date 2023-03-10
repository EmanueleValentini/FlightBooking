package it.alten.flightbooking.repository;

import it.alten.flightbooking.model.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightRepository {

    private List<Flight> flights = new ArrayList<>();
    public FlightRepository(){
        LocalDate date = new LocalDate(2023,03,10);
        flights.add(
                new Flight(1,"FCO","BCN","10:30:00","12:30:00",date,200,"AAAA")
        );
        flights.add(
                new Flight(2,"FCO","BCN","18:30:00","20:30:00",date,200,"BBBB")
        );
        flights.add(
                new Flight(3,"FCO","CFU","18:30:00","20:30:00",date,200,"CCCC")
        );
        flights.add(
                new Flight(4,"FCO","CFU","08:30:00","10:30:00",date,200,"DDDD")
        );
    }

    public Flight findByFlightNumber(String flightNumber){
        for (Flight f:
             flights) {
            if (f.getFlightNumber().equals(flightNumber)){
                return f;
            }
        }
        return null;
    }

    public Flight findByFlightNumberAndFlightDate(String flightNumber, Date flightDate) {
        for (Flight f:
             flights) {
            if(f.getFlightNumber().equals(flightNumber) && f.getDate()==flightDate){
                return f;
            }
        }
        return null;
    }

    public List<Flight> findByFromAirportAndToAirportAndDate(String fromAirport, String toAirport, Date date) {
        List<Flight> found = new ArrayList<>();
        for (Flight f:
             flights) {
            if(f.getFromAirport().equals(fromAirport) && f.getToAirport().equals(toAirport) && f.getDate()==date){
                found.add(f);
            }
        }
        return found;
    }
}
