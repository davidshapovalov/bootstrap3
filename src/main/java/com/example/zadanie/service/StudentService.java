package com.example.zadanie.service;

import com.example.zadanie.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Integer id);
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    Student findById(int id);
    List<Student> getSortedStudents();
}