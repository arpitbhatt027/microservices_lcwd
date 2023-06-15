package com.rating.service.impl;

import com.rating.entities.UserEntity;
import com.rating.exceptions.ResourceNotFoundException;
import com.rating.payload.Ratings;
import com.rating.repo.UserRepository;
import com.rating.service.UserService;
import com.rating.utilities.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(String userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given id :: " + userId));
        List<Ratings> list = restTemplate.getForObject("http://localhost:8083/ratings/user/" + userId, List.class);
        logger.info("" + list);
        user.setRatings(list);
        return user;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        user.setUserId(UtilityMethods.generateRandomId());
        return userRepository.save(user);
    }
}
