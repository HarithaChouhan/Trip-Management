package com.example.tripplanner.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tripplanner.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    //List<Trip> findByCategories_Name(String name); 
   // List<Trip> findTripByUserId(Long userId); 
    
    List<Trip> findBySourceAndDestination(String source, String destination);
}