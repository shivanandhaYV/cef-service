package com.primesoft.service.impl;

import com.primesoft.dto.EmployeeDto;
import com.primesoft.entity.Employee;
import com.primesoft.mapper.EmployeeMapper;
import com.primesoft.repo.EmployeeRepository;
import com.primesoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeRepo.save(employeeMapper.employeeDtoToEmployee(employeeDto));

        return employeeMapper.employeeToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployee(UUID id) {
        return employeeMapper.employeeToEmployeeDto(employeeRepo.findById(id).get());
    }

    @Override
    public EmployeeDto deleteEmployee(UUID id) {
        Employee emp = employeeRepo.findById(id).get();
        employeeRepo.delete(emp);
        EmployeeDto employee = employeeMapper.employeeToEmployeeDto(emp);

        return employee;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
//        employeeMapper.updateEmployeeFromEmployeeDto();
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return null;
    }
}
