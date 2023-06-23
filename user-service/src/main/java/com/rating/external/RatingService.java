package com.rating.external;

import com.rating.payload.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("ratings/user/{user-id}")
    Ratings[] getRatingByUserId(@PathVariable("user-id") String ratingId);

    @PostMapping("/ratings")
    Ratings createRating(Ratings ratings);

    @PostMapping("/ratings/{rating-id}")
    Ratings updateRating(@PathVariable("rating-id") String ratingId, Ratings ratings);
}
