package com.example.tripplanner.service;

import java.util.List;

import com.example.tripplanner.model.Tourist;

public interface TouristService {
	public Tourist addTourist(Tourist tourist);
	public List<Tourist> getAllTourist();
	
	public Tourist getTouristById(int tId,Tourist tourist);
	
	public void removeTouristById(int tId);
	
	public Tourist addTouristToTrip(Tourist tourist,Long tripId);
}
