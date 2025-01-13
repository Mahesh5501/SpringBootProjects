package com.mysecondspringbootapp.mysecondspringbootapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mysecondspringbootapp.mysecondspringbootapp.model.MyUser;
import com.mysecondspringbootapp.mysecondspringbootapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/user")
public class Usercontroller {
    
    @Autowired
    private UserService service;


    @GetMapping("/")
    public String test() {
        return "This is my second web application!!!";
    }
    
    @PostMapping("/register")
    public String registerUser(@RequestBody MyUser user) {
        return service.register(user);
    }
    
    @PostMapping("/login")
    public String userLogin(@RequestBody MyUser user) {
        return service.login(user);
    }

}
