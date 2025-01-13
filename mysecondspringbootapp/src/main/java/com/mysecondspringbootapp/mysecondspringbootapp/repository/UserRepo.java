package com.mysecondspringbootapp.mysecondspringbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysecondspringbootapp.mysecondspringbootapp.model.MyUser;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer>{
    
}
