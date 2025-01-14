package com.jwt.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwt.model.User;
import com.jwt.jwt.services.JwtService;
import com.jwt.jwt.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
       return userService.addUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if(authenticate.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        }else{
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
    

}
