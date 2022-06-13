package com.primesoft.service;

import com.primesoft.dto.EmployeeDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(UUID id);

    EmployeeDto deleteEmployee(UUID id);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();
}
