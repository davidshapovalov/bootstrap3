package com.example.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.zadanie.entity.Student;
import org.springframework.transaction.annotation.Transactional;
import com.example.zadanie.repository.StudentRepository;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Student> getSortedStudents() {
        return studentRepository.findAllByOrderByLastNameAsc();
    }
}