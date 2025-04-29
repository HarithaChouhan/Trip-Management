package com.example.tripplanner.serviceimpl;

import com.example.tripplanner.model.Booking;
import com.example.tripplanner.repository.BookingRepository;
import com.example.tripplanner.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking updatedBooking) {
        Optional<Booking> existingBookingOpt = bookingRepository.findById(bookingId);
        if (existingBookingOpt.isPresent()) {
            Booking existing = existingBookingOpt.get();
            existing.setBookingReference(updatedBooking.getBookingReference());
            existing.setBookingDate(updatedBooking.getBookingDate());
            existing.setStatus(updatedBooking.getStatus());
            existing.setTrip(updatedBooking.getTrip());
            existing.setUser(updatedBooking.getUser());
            return bookingRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
