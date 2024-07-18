package com.jc.gymbasicsystem.application.services.interfaces;

import com.jc.gymbasicsystem.application.dto.employee.CreateEmployeeDto;
import com.jc.gymbasicsystem.domain.entities.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(String employeeId);

    EmployeeEntity createEmployee(CreateEmployeeDto createEmployeeDto);

    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

    void deleteEmployee(String employeeId);
}
