package com.rating.service.impl;

import com.rating.entities.UserEntity;
import com.rating.exceptions.ResourceNotFoundException;
import com.rating.repo.UserRepository;
import com.rating.service.UserService;
import com.rating.utilities.UtilityMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given id :: " + userId));
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        user.setUserId(UtilityMethods.generateRandomId());
        return userRepository.save(user);
    }
}
