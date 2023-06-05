package com.rating.controller;

import com.rating.entities.UserEntity;
import com.rating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getUserList();
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserEntity> getAllUserById(@PathVariable("user-id") String userId) {
        UserEntity user = userService.getById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        UserEntity user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

}
