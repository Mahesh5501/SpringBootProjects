package com.jwt.jwt.controllers;

import org.springframework.web.bind.annotation.*;

import com.jwt.jwt.model.Employee;
import com.jwt.jwt.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }


    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.save(employee);
    }


}
