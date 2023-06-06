package com.rating.service;

import com.rating.entities.Ratings;

import java.util.List;

public interface RatingService {

    Ratings saveRating(Ratings rating);

    Ratings getRating(String id);

    List<Ratings> getRatings();
}
