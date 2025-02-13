package com.springbootmongo.springboot_mongodb.repository;

import com.springbootmongo.springboot_mongodb.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {
    
}
