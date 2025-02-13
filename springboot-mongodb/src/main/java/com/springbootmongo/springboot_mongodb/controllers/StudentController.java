package com.springbootmongo.springboot_mongodb.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springbootmongo.springboot_mongodb.models.Student;
import com.springbootmongo.springboot_mongodb.repository.StudentRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class StudentController {
    @Autowired    
    StudentRepo repo;

    @GetMapping("/")
    public String testMethod() {
        return "Student";
    }

    @GetMapping("/students")
    public List<Student> getMethodName() {
        return repo.findAll();
    }
    
    
}
