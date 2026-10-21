package com.example.zadanie.repository;

import com.example.zadanie.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findAllByOrderByLastNameAsc();
    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);
}