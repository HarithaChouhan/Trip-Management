package com.example.tripplanner.service;

import com.example.tripplanner.model.Wishlist;

import java.util.List;

public interface WishlistService {
    Wishlist createWishlist(Wishlist wishlist);
    Wishlist getWishlistById(Long wishlistId);
    List<Wishlist> getAllWishlists();
    Wishlist updateWishlist(Long wishlistId, Wishlist wishlist);
    void deleteWishlist(Long wishlistId);
    List<Wishlist> getWishlistsByUserId(Long userId);
}
