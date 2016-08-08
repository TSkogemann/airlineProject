/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.skogemann.airline.project;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Thomas Skogemann
 */
@Controller
@RequestMapping(value = "/api/")
public class ApiController {

    String baseUrl = "http://angularairline-plaul.rhcloud.com";

    @RequestMapping(value = "/flightinfo/{startLoc}/{endLoc}/{date}/{tickets}", method = RequestMethod.GET)
    @ResponseBody
    public FlightResponse search(
            @PathVariable("startLoc") String startLoc,
            @PathVariable("endLoc") String endLoc,
            @PathVariable("date") String date,
            @PathVariable("tickets") int ticket) {

        return doSearch(startLoc, endLoc, date, ticket);
    }

    @RequestMapping(value = "/flightinfo/{startLoc}/{date}/{tickets}", method = RequestMethod.GET)
    @ResponseBody
    public FlightResponse search(
            @PathVariable("startLoc") String startLoc,
            @PathVariable("date") String date,
            @PathVariable("tickets") int ticket) {

        return doSearch(startLoc, null, date, ticket);
    }

    private FlightResponse doSearch(String startLoc, String endLoc, String date, int ticket) throws RestClientException {
        String url;
        if (endLoc == null) {
            url = baseUrl + "/api/flightinfo/" + startLoc + "/" + date + "/" + ticket;
        } else {
            url = baseUrl + "/api/flightinfo/" + startLoc + "/" + endLoc + "/" + date + "/" + ticket;
        }
        System.out.println("kalder remote - search");
        RestTemplate template = new RestTemplate();
        FlightResponse flightResponse = template.getForObject(url, FlightResponse.class);
        System.out.println(flightResponse);
        System.out.println(" search remote end");
        return flightResponse;
    }

    // Reservation and response
    @RequestMapping(value = "/reservation/{flightId}", method = RequestMethod.POST)
    @ResponseBody
    public ReservationResponse bookFlight(
            @PathVariable("flightId") String flightId,
            @RequestBody Reservation reservation) {

        String url = "http://angularairline-plaul.rhcloud.com/api/flightreservation";

        System.out.println("kalder remote");
        RestTemplate template = new RestTemplate();
        ResponseEntity<ReservationResponse> postForEntity = template.postForEntity(url, reservation, ReservationResponse.class);
        System.out.println(postForEntity);
        System.out.println("bookFlight apicontroller");

        return postForEntity.getBody();
    }

    @ExceptionHandler
    public ResponseEntity<JsonError> handleException(Exception e) {
        e.printStackTrace();
        JsonError msg = new JsonError();
        msg.setMessage(e.getMessage());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<JsonError> handleHttpClientException(HttpClientErrorException e) {
        e.printStackTrace();
        JsonError msg = new JsonError();
        msg.setMessage(e.getResponseBodyAsString());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    private FlightResponse response() {
        Flight flight1 = new Flight("flightId", "flightNumber", "date", 1, 2, 3, "origin", "destination");
        Flight flight2 = new Flight("flightId2", "flightNumber2", "date2", 2, 3, 4, "origin2", "destination2");
        Flight flight3 = new Flight("flightId3", "flightNumber3", "date3", 3, 4, 5, "origin3", "destination3");
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        FlightResponse response = new FlightResponse();
        response.setAirline("TestAirline");
        response.setFlights(flights);
        return response;
    }

    private Reservation bookingResponse() {

        System.out.println("testsdf");
        return new Reservation();
    }

    public Passenger createPassenger(int i) {

        Passenger temp = new Passenger();
        temp.setFirstName("first Name" + i);
        temp.setLastName("last Name" + i);
        return temp;
    }
}
