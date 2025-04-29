package com.example.tripplanner.serviceimpl;

import com.example.tripplanner.model.Wishlist;
import com.example.tripplanner.repository.WishlistRepository;
import com.example.tripplanner.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public Wishlist createWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist getWishlistById(Long wishlistId) {
        return wishlistRepository.findById(wishlistId).orElse(null);
    }

    @Override
    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    @Override
    public Wishlist updateWishlist(Long wishlistId, Wishlist updatedWishlist) {
        Optional<Wishlist> existing = wishlistRepository.findById(wishlistId);
        if (existing.isPresent()) {
            Wishlist wishlist = existing.get();
            wishlist.setDreamTrip(updatedWishlist.getDreamTrip());
            wishlist.setUser(updatedWishlist.getUser());
            return wishlistRepository.save(wishlist);
        }
        return null;
    }

    @Override
    public void deleteWishlist(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }

    @Override
    public List<Wishlist> getWishlistsByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }
}
