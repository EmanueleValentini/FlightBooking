package it.alten.flightbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate flightDate;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime depatureTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime arrivalTime;

    private String landingAirport;

    private String takeOffAirport;

    private Integer numSeats;

    private String passengerName;

}