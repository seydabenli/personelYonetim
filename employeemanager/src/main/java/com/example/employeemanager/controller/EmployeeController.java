package com.example.employeemanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    List<Employee> employees = employeeService.findAllEmployees();
    return ResponseEntity.ok(employees);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
    Employee employees = employeeService.findEmployeeById(id);
    return ResponseEntity.ok(employees);
  }

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    Employee employees = employeeService.addEmployee(employee);
    return ResponseEntity.ok(employees);
  }

  @PutMapping("/update")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
    Employee employees = employeeService.updateEmployee(employee);
    return ResponseEntity.ok(employees);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id) {
    employeeService.deleteEmployee(id);
    return ResponseEntity.ok().build();
  }

}
