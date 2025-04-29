package com.example.tripplanner.service;

import java.util.List;
import com.example.tripplanner.model.Trip;

public interface TripService {
   
    Trip getTripById(Long tripId);
    List<Trip> getAllTrips();
    Trip updateTrip(Long tripId, Trip tripDetails);
    void deleteTrip(Long tripId);
    //List<Trip> getTripsByUserId(Long userId);
	Trip addTrip(Trip trip);
	public void removeTripById(Long tripId);
	
    public List<Trip> searchTripsBySourceDestination(String source, String destination);
}