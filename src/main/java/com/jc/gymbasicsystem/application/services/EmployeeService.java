package com.jc.gymbasicsystem.application.services;

import com.jc.gymbasicsystem.application.dto.employee.CreateEmployeeDto;
import com.jc.gymbasicsystem.application.services.interfaces.IEmployeeService;
import com.jc.gymbasicsystem.domain.entities.EmployeeEntity;
import com.jc.gymbasicsystem.domain.usercases.employee.CreateEmployeeUserCase;
import com.jc.gymbasicsystem.domain.usercases.employee.GetEmployeesUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private GetEmployeesUserCase getEmployeesUserCase;

    @Autowired
    private CreateEmployeeUserCase createEmployeeUserCase;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return getEmployeesUserCase.execute();
    }

    @Override
    public EmployeeEntity getEmployeeById(String employeeId) {
        return null;
    }

    @Override
    public EmployeeEntity createEmployee(CreateEmployeeDto createEmployeeDto) {
        return createEmployeeUserCase.execute(createEmployeeDto);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public void deleteEmployee(String employeeId) {

    }
}
