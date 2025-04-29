package com.example.tripplanner.repository;

import com.example.tripplanner.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId); // Find bookings for a specific user
    
    List<Booking> findByTripTripId(Long tripId); // Find bookings for a specific trip
}