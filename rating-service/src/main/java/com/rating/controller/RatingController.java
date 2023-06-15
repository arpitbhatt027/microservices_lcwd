package com.rating.controller;

import com.rating.entities.Ratings;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Ratings>> getAllRatings() {
        List<Ratings> ratings = ratingService.getRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{rating-id}")
    public ResponseEntity<Ratings> getRatingById(@PathVariable("rating-id") String ratingId) {
        Ratings ratings = ratingService.getRating(ratingId);
        return ResponseEntity.ok(ratings);
    }

    @PostMapping
    public ResponseEntity<Ratings> saveRating(@RequestBody Ratings ratings) {
        Ratings ratings1 = ratingService.saveRating(ratings);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratings1);
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<Ratings>> getUserRatings(@PathVariable("user-id") String userId) {
        List<Ratings> ratings = ratingService.getUserRatings(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }
}
