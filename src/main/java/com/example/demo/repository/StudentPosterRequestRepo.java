package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentPosterRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentPosterRequestRepo extends JpaRepository<StudentPosterRequest, Long> {

    Optional<StudentPosterRequest> findByStudent(Student student);
}
