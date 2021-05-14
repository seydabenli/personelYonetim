package com.example.employeemanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanager.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

  void deleteEmployeeById(Long id);

  Optional<Employee> findEmployeeById(Long id);
}
