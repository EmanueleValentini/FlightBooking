package it.alten.flightbooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date flightDate;

    private String flightNumber;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime depatureTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime arrivalTime;

    private String landingAirport;

    private String takeOffAirport;

    private Integer seatsBooked;

    private String passengerName;
}
