package com.example.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.zadanie.entity.Student;
import org.springframework.transaction.annotation.Transactional;
import com.example.zadanie.dao.StudentDAO;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        studentDAO.deleteById(id);
    }

    @Override
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName) {
        return studentDAO.findByFirstNameAndLastName(firstName, lastName);
    }

}