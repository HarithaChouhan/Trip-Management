package com.example.tripplanner.service;

import com.example.tripplanner.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking createBooking(Booking booking);
    void deleteBooking(Long bookingId);
    Booking updateBooking(Long bookingId, Booking booking);
	Booking getBookingById(Long bookingId);
}