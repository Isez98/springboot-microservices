package dev.isez.employeeservice.service;

import dev.isez.employeeservice.dto.APIResponseDto;
import dev.isez.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
