/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.skogemann.airline.project;

import java.util.Date;
import java.util.List;

/**
 *{
 "flightNumber":"String",
 "origin":"String (Friendly name + IATA)",
 "destination":"String (Friendly name + IATA)",
 "date":"ISO-8601-Date/time",
 "flightTime":"Integer (minutes)",
 "numberOfSeats":"Integer",
 "reserveeName":"String",
 "passengers":[
 {
 "firstName":"String",
 "lastName":"String"
 }
 ]
}

 * @author Thomas Skogemann
 */
public class ReservationResponse {
    
    String flightNumber;
    String origin;
    String destination;
    Date date;
    int flightTime;
    int numberOfSeats;
    String reserveeName;
    List<Passenger> passengers;

    public ReservationResponse() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveeName() {
        return reserveeName;
    }

    public void setReserveeName(String reserveeName) {
        this.reserveeName = reserveeName;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
    
    
}
