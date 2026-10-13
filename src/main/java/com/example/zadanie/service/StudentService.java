package com.example.zadanie.service;

import com.example.zadanie.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> findAll();
    public Student save(Student student);
    public void deleteById(Integer id);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    Student findById(int id);
}
