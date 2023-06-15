package com.rating.service.impl;

import com.rating.entities.Ratings;
import com.rating.exceptions.ResourceNotFoundException;
import com.rating.repo.RatingRepo;
import com.rating.service.RatingService;
import com.rating.utilities.UtilityMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Ratings saveRating(Ratings rating) {
        rating.setId(UtilityMethods.generateRandomId());
        return ratingRepo.save(rating);
    }

    @Override
    public Ratings getRating(String id) {
        Ratings ratings = ratingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating not found with given id :: " + id));
        return ratings;
    }

    @Override
    public List<Ratings> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Ratings> getUserRatings(String userId) {
        return ratingRepo.findAllByUserId(userId);
    }
}
