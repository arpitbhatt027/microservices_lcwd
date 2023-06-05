package com.rating.service;

import com.rating.entities.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    List<UserEntity> getUserList();

    UserEntity getById(String userId);

    UserEntity saveUser(UserEntity user);
}
