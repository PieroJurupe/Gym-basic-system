package com.jc.gymbasicsystem.domain.usercases.employee;

import com.jc.gymbasicsystem.domain.entities.EmployeeEntity;
import com.jc.gymbasicsystem.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetEmployeesUserCase {

    @Autowired
    private EmployeeRepository employeeRepository;

    public GetEmployeesUserCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> execute() {
        return employeeRepository.findAll();
    }
}
