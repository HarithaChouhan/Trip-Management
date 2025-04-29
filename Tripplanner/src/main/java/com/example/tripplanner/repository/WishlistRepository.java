package com.example.tripplanner.repository;

import com.example.tripplanner.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUserId(Long userId); // Find wishlists for a specific user
    
    List<Wishlist> findByDreamTripContaining(String keyword); // Find wishlists with partial match on dream trip
    
}