package com.rating.service.impl;

import com.rating.entities.UserEntity;
import com.rating.exceptions.ResourceNotFoundException;
import com.rating.external.HotelService;
import com.rating.external.RatingService;
import com.rating.payload.Hotel;
import com.rating.payload.Ratings;
import com.rating.repo.UserRepository;
import com.rating.service.UserService;
import com.rating.utilities.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(String userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given id :: " + userId));
        Ratings[] ratingsOfUser = ratingService.getRatingByUserId(userId);
        logger.info("Ratings of user '{0}' - ", ratingsOfUser);

        List<Ratings> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());

        List<Ratings> ratingList = ratings.stream().map(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        user.setUserId(UtilityMethods.generateRandomId());
        return userRepository.save(user);
    }
}
