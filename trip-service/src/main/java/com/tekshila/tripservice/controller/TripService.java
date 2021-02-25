package com.tekshila.tripservice.controller;

import com.tekshila.tripservice.domain.Trip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
 * Returns the trips the user has made in the past
 *
 */
@RestController
@RequestMapping("/tekshila/api/v1/trips")
@Slf4j
public class TripService {

    private List<Trip> trips = Arrays.asList(
            new Trip(1,2,"city1","from1","to1"),
            new Trip(2,2,"city2","from2","to2"),
            new Trip(3,2,"city3","from3","to3"),
            new Trip(4,1,"city4","from4","to4"),
            new Trip(5,3,"city5","from5","to5"),
            new Trip(6,3,"city6","from6","to6")
    );

    /*
     * Returns the trips of the customers
     */
    @GetMapping("{customerId}")
    public List<Trip> listTrips() {
        return
    }

}
