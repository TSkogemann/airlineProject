/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.skogemann.airline.project;

import java.util.List;

/**
 *"flightID": String,
 "numberOfSeats": Integer,
 "reserveeName": String,
 "reservePhone": String,
 "reserveeEmail": String (valid email),
 "passengers":[
 {
 "firstName":String,
 "lastName": String
 * @author Thomas Skogemann
 */
public class Reservation {
    
    String flightID;
    int numberOfSeats;
    String reserveeName;
    String reservePhone;
    String reserveeEmail;
    List<Passenger> passengers;

    public Reservation() {
    }
    
    

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
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

    public void setReserveeName(String reserveName) {
        this.reserveeName = reserveName;
    }

    public String getReservePhone() {
        return reservePhone;
    }

    public void setReservePhone(String reservePhone) {
        this.reservePhone = reservePhone;
    }

    public String getReserveeEmail() {
        return reserveeEmail;
    }

    public void setReserveeEmail(String reserveEmail) {
        this.reserveeEmail = reserveEmail;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
    
    
}
