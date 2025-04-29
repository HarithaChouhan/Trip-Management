package com.example.tripplanner.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tripplanner.model.Tourist;
import com.example.tripplanner.model.Trip;
import com.example.tripplanner.repository.TouristRepository;
import com.example.tripplanner.service.TouristService;
import com.example.tripplanner.service.TripService;

@Service
public class TouristServiceImpl implements TouristService{
	
	@Autowired
	TouristRepository touristRepository;
	
	@Autowired
	TripService tripService;

	@Override
	public Tourist addTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		return touristRepository.save(tourist);
	}

	@Override
	public List<Tourist> getAllTourist() {
		// TODO Auto-generated method stub
		return touristRepository.findAll();
	}

	@Override
	public Tourist getTouristById(int tId, Tourist tourist) {
		// TODO Auto-generated method stub
		return touristRepository.findById(tId).get();
	}

	@Override
	public void removeTouristById(int tId) {
		// TODO Auto-generated method stub
		touristRepository.deleteById(tId);
		
	}

	@Override
	public Tourist addTouristToTrip(Tourist tourist, Long tripId) {
		// TODO Auto-generated method stub
		Trip trip=tripService.getTripById(tripId);
		tourist.setTrip(trip);
		return touristRepository.save(tourist);
	}

}
