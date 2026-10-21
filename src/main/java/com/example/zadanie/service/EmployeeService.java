package com.example.zadanie.service;

import com.example.zadanie.entity.Employee;

public interface EmployeeService {
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(Integer id);
}