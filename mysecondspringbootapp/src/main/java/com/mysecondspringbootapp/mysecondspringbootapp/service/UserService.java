package com.mysecondspringbootapp.mysecondspringbootapp.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysecondspringbootapp.mysecondspringbootapp.model.MyUser;
import com.mysecondspringbootapp.mysecondspringbootapp.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public String register(MyUser user) {
        
        if(checkUserExist(user)){
            return "User already exists";
        }else{
            String changedpwd = encryptPassword(user.getPassword());
            user.setPassword(changedpwd);
            repo.save(user);
            return "User registered successfully";
        }
        
    }

    public String login(MyUser user) {    
        return checkUserExist(user)? "Login Successful" : "Login Failed";
    }
    

    private String encryptPassword(String password) {
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUserExist(MyUser user) {
        Optional<MyUser> checkUser = repo.findAll().stream()
            .filter(u -> u.getUserName().equals(user.getUserName()) && u.getPassword().equals(encryptPassword(user.getPassword())))
            .findFirst();
    
        return checkUser.isPresent() ? true : false;
    }

    
}
