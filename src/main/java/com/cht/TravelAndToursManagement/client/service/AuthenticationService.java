package com.cht.TravelAndToursManagement.client.service;

import com.cht.TravelAndToursManagement.client.exception.ValidationException;
import com.cht.TravelAndToursManagement.client.model.Employee;
import com.cht.TravelAndToursManagement.client.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationService {
    private final EmployeeRepository employeeRepository;

    public AuthenticationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean authenticate(String email, String password) {
        return employeeRepository.validateCredentials(email, password);
    }

    public Employee register(Employee employee) throws ValidationException {
        validateEmployee(employee);
        return employeeRepository.save(employee);
    }

    private void validateEmployee(Employee employee) throws ValidationException {
        if (employee == null) {
            throw new ValidationException("Employee cannot be null");
        }

        if (employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email is required");
        }

        if (employee.getPassword() == null || employee.getPassword().trim().isEmpty()) {
            throw new ValidationException("Password is required");
        }

        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new ValidationException("Email already exists");
        }
    }

}
