package it.alten.flightbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Flight implements Serializable {
    private int id;

    private String fromAirport;

    private String toAirport;


    private String depatureTime;

    private String landingTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private int seats;

    private String flightNumber;
}
