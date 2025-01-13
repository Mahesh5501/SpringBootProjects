package com.myfirstspringbootapp.myfirstspringbootapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
public class User {
    
    @Id
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "user_name")
    private String name;
    
    @Column(name = "user_email")
    private String email;
    
    @Column (name = "user_password")
    private String password;
    
}
