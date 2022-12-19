package com.example.demo.repository;

import com.example.demo.model.StudentServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentServiceMemberRepo extends JpaRepository<StudentServiceMember, Long> {
    Optional<StudentServiceMember> findByUsername(String username);

    List<StudentServiceMember> findAllByOrderByStusluMemberIDDesc();
}
