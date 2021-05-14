package com.example.employeemanager.service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.IEmployeeRepository;

@Service
@Transactional
public class EmployeeService {

  private final IEmployeeRepository IEmployeeRepository;

  public EmployeeService(IEmployeeRepository IEmployeeRepository) {
    this.IEmployeeRepository = IEmployeeRepository;
  }

  public Employee addEmployee(Employee employee) {
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return IEmployeeRepository.save(employee);
  }


  public List<Employee> findAllEmployees() {
    return IEmployeeRepository.findAll();
  }

  public Employee updateEmployee(Employee employee) {
    return IEmployeeRepository.save(employee);
  }

  public void deleteEmployee(Long id) {
    IEmployeeRepository.deleteEmployeeById(id);
  }

  public Employee findEmployeeById(Long id) {
    return IEmployeeRepository.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("Kullanıcı bulunamadı"+id));
  }
}
