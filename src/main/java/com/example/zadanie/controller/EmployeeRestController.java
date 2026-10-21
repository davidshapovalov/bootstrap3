package com.example.zadanie.controller;

import com.example.zadanie.entity.Employee;
import com.example.zadanie.response.ResponseFactory;
import com.example.zadanie.response.ResponseWrapper;
import com.example.zadanie.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final ResponseFactory response;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ResponseFactory response) {
        this.employeeService = employeeService;
        this.response = response;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return response.ok("Zamestnanec úspešne načítaný", employee);
    }

    @PostMapping("/employees")
    public ResponseEntity<ResponseWrapper<Employee>> createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(null);
        Employee savedEmployee = employeeService.save(employee);
        return response.created("Zamestnanec úspešne vytvorený", savedEmployee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee employee) {
        employeeService.findById(id);
        employee.setId(id);
        Employee updatedEmployee = employeeService.save(employee);
        return response.ok("Zamestnanec úspešne aktualizovaný", updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Void>> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return response.ok("Zamestnanec úspešne zmazaný");
    }
}