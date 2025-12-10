package com.cht.TravelAndToursManagement.client.service;

import com.cht.TravelAndToursManagement.client.model.Employee;
import com.cht.TravelAndToursManagement.client.repository.EmployeeRepository;

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

}
