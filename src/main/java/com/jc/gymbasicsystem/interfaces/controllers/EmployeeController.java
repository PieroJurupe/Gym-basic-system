package com.jc.gymbasicsystem.interfaces.controllers;

import com.jc.gymbasicsystem.application.dto.employee.CreateEmployeeDto;
import com.jc.gymbasicsystem.application.services.EmployeeService;
import com.jc.gymbasicsystem.domain.entities.EmployeeEntity;
import jakarta.validation.Valid;
import org.hibernate.action.internal.EntityAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<EmployeeEntity>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeEntity> createEmployee(
            @Valid @RequestBody CreateEmployeeDto createEmployeeDto
            ) {
        return ResponseEntity.ok(employeeService.createEmployee(createEmployeeDto));
    }
}
