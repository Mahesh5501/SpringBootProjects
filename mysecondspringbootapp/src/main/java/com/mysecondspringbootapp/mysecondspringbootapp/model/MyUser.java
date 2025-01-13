package com.mysecondspringbootapp.mysecondspringbootapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq") 
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1) 
    private int userId;
    
    private String userName;
    private String password;


}
