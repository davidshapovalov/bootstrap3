package com.example.zadanie.dao;

import com.example.zadanie.entity.Student;
import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Integer id);
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    Student findById(int id);
}