package com.cht.TravelAndToursManagement.client.repository;

import com.cht.TravelAndToursManagement.client.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findByEmail(String email);

    List<Employee> findAll();

    Employee save(Employee employee);

    void delete(Long id);

    boolean validateCredentials(String email, String password);
}
