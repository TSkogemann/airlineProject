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
}
