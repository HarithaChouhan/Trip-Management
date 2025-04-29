package com.example.tripplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripplanner.model.Tourist;
import com.example.tripplanner.service.TouristService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/tourist")
public class TouristController {
	
	@Autowired
	TouristService touristService;
	
	@PostMapping
	public ResponseEntity<Tourist> addTourist(Tourist tourist){
		return new ResponseEntity<Tourist> (touristService.addTourist(tourist),HttpStatus.CREATED);
	}
	
	@PostMapping("/addTouristtoTrip/{tripId}")
	public ResponseEntity<Tourist> addTouristtoTrip(@PathVariable("tripId") Long tripId,@RequestBody Tourist tourist) {
		return new ResponseEntity<Tourist>(touristService.addTouristToTrip(tourist, tripId),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Tourist> getAllTourist(){
		return touristService.getAllTourist();
	}
	
	@GetMapping("{tId}")
	public ResponseEntity<Tourist> getTouristById(@PathVariable("tId") int tId,@RequestBody Tourist tourist){
		return new ResponseEntity<Tourist> (touristService.getTouristById(tId, tourist),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{tId}")
	public List<Tourist> removeTouristById(@PathVariable("tId") int tId){
		touristService.removeTouristById(tId);
		return touristService.getAllTourist();
	}
}
