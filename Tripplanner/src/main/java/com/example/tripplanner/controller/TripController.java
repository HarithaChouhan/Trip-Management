package com.example.tripplanner.controller;

import com.example.tripplanner.model.Trip;
import com.example.tripplanner.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @GetMapping("/{tripId}")
    public Trip getTrip(@PathVariable Long tripId) {
        return tripService.getTripById(tripId);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @PutMapping("/{tripId}")
    public Trip updateTrip(@PathVariable("tripId") Long tripId, @RequestBody Trip trip) {
        return tripService.updateTrip(tripId, trip);
    }

    @DeleteMapping("/{tripId}")
    public List<Trip> removeTripById(@PathVariable Long tripId) {
    	tripService.removeTripById(tripId);
        return tripService.getAllTrips();
    }
    
    @GetMapping("/search/{source}/{destination}")
    public List<Trip> searchTrips(@PathVariable("source") String source,@PathVariable("destination") String destination) {
        return tripService.searchTripsBySourceDestination(source, destination);
    }

    
}
