/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.skogemann.airline.project;

/**
 * {
 * "flightID": "2257-1457179200009", "flightNumber": "COL2257", "date":
 * "2016-03-05T13:00:00.000Z", "numberOfSeats": 3, "totalPrice": 180,
 * "traveltime": 120, "origin": "CDG", "destination": "CPH" }
 *
 * @author Thomas Skogemann
 */
public class Flight {

    String flightID;
    String flightNumber;
    String date;
    int numberOfSeats;
    int totalPrice;
    int traveltime;
    String origin;
    String destination;

    public Flight(String flightID, String flightNumber, String date, int numberOfSeats, int totalPrice, int traveltime, String origin, String destination) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.date = date;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
        this.traveltime = traveltime;
        this.origin = origin;
        this.destination = destination;
    }

    
    
    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(int traveltime) {
        this.traveltime = traveltime;
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
    
}
