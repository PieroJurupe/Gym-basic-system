package com.jc.gymbasicsystem.domain.usercases.employee;

import com.jc.gymbasicsystem.application.dto.employee.CreateEmployeeDto;
import com.jc.gymbasicsystem.domain.entities.EmployeeEntity;
import com.jc.gymbasicsystem.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateEmployeeUserCase {

    @Autowired
    private EmployeeRepository employeeRepository;

    public CreateEmployeeUserCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity execute(CreateEmployeeDto createEmployeeDto) {
        EmployeeEntity createEmployee = new EmployeeEntity();
        createEmployee.setFirstName(createEmployeeDto.getFirstName());
        createEmployee.setLastName(createEmployeeDto.getLastName());
        createEmployee.setAddress(createEmployeeDto.getAddress());
        createEmployee.setPhoneNumber(createEmployeeDto.getPhoneNumber());
        createEmployee.setEmail(createEmployeeDto.getEmail());
        createEmployee.setActive(true);

        return employeeRepository.save(createEmployee);
    }
}
