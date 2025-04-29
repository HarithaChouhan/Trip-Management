package com.example.tripplanner.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tripplanner.model.Trip;
import com.example.tripplanner.repository.TripRepository;
import com.example.tripplanner.service.TripService;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip getTripById(Long tripId) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        return optionalTrip.orElseThrow(() -> new RuntimeException("Trip not found with id " + tripId));
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip updateTrip(Long tripId, Trip updatedTrip) {
        Optional<Trip> tripOpt = tripRepository.findById(tripId);
        if (tripOpt.isPresent()) {
            Trip trip = tripOpt.get();
            trip.setTrip_type(updatedTrip.getTrip_type());
            trip.setSource(updatedTrip.getSource());
            trip.setDestination(updatedTrip.getDestination());
            trip.setBudget(updatedTrip.getBudget());
            trip.setTrip_startDate(updatedTrip.getTrip_startDate());
            trip.setTrip_endDate(updatedTrip.getTrip_endDate());
            return tripRepository.save(trip);
        }
        return null;
    }

    @Override
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
        
    }
   

   /* @Override
    public List<Trip> getTripsByUserId(Long userId) {
        return tripRepository.findTripByUserId(userId);
    }*/

	@Override
	public void removeTripById(Long tripId) {
		// TODO Auto-generated method stub
		Trip trip=getTripById(tripId);
		 tripRepository.deleteById(tripId);;
	}
	
	@Override
    public List<Trip> searchTripsBySourceDestination(String source, String destination) {
        return tripRepository.findBySourceAndDestination(source, destination);
    }

}