package com.springbootmongo.springboot_mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "students") // Specifies the collection name (important!)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    
    @JsonIgnore
    @Id
    private String id;

    private int studentId;
    private String name;
    private int rollNumber;
}
