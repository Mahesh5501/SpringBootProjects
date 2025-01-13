package com.myfirstspringbootapp.myfirstspringbootapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myfirstspringbootapp.myfirstspringbootapp.model.User;
import com.myfirstspringbootapp.myfirstspringbootapp.repository.UserRepository;


@RestController
public class TestController {
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String testMethod() {
        return "Hello this is home page of my first spring boot app!!!!!";
    }
    
    @PostMapping("/users/add")
    public List<User> postMethod(@RequestBody User user) {
        userRepo.save(user);
        return userRepo.findAll();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        return userRepo.findById(userId).get();
    }

    @DeleteMapping("/user/{userId}")
    public List<User> deleteUser(@PathVariable int userId) {
        userRepo.deleteById(userId);
        return userRepo.findAll();
    }
}
