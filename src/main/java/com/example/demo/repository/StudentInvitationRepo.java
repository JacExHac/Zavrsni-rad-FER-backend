package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentInvitation;
import com.example.demo.model.StudentServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentInvitationRepo extends JpaRepository<StudentInvitation, Long> {

    Optional<StudentInvitation> findByStudent(Student student);

    List<StudentInvitation> findAllByStudentServiceMember(StudentServiceMember studentServiceMember);
}
