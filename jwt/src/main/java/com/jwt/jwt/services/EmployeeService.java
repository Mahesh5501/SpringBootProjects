package com.jwt.jwt.services;

import org.springframework.stereotype.Service;

import com.jwt.jwt.model.Employee;
import com.jwt.jwt.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }


}
