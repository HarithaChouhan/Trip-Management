package com.example.tripplanner.controller;

import com.example.tripplanner.model.Wishlist;
import com.example.tripplanner.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.createWishlist(wishlist);
    }

    @GetMapping("/{id}")
    public Wishlist getWishlist(@PathVariable Long wishlistId) {
        return wishlistService.getWishlistById(wishlistId);
    }

    @GetMapping
    public List<Wishlist> getAllWishlists() {
        return wishlistService.getAllWishlists();
    }

    @PutMapping("/{id}")
    public Wishlist updateWishlist(@PathVariable Long wishlistId, @RequestBody Wishlist wishlist) {
        return wishlistService.updateWishlist(wishlistId, wishlist);
    }

    @DeleteMapping("/{wishlistid}")
    public void deleteWishlist(@PathVariable Long wishlistId) {
        wishlistService.deleteWishlist(wishlistId);
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistsByUserId(@PathVariable Long userId) {
        return wishlistService.getWishlistsByUserId(userId);
    }
}
