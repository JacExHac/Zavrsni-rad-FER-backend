package com.example.demo.service;


import com.example.demo.DTOs.SendInvitationAnswerDTO;
import com.example.demo.DTOs.StudentInvitationDTO;
import com.example.demo.model.Student;
import com.example.demo.model.StudentInvitation;
import com.example.demo.repository.StudentInvitationRepo;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentInvitationService {

    @Autowired
    private StudentInvitationRepo studentInvitationRepo;

    @Autowired
    private StudentRepo studentRepo;


    public StudentInvitationDTO getInvitationByStudentID(long studentID) {

        Optional<Student> student = studentRepo.findById(studentID);

        if(!student.isPresent()) {
            return null;
        }

        Optional<StudentInvitation> studentInvitation = studentInvitationRepo.findByStudent(student.get());

        if(!studentInvitation.isPresent()) {
            return null;
        }

        StudentInvitationDTO studentInvitationDTO = new StudentInvitationDTO(
                studentInvitation.get().getStudentInvitationID(),
                studentInvitation.get().getStudentResponse(),
                studentInvitation.get().getStudentText(),
                studentInvitation.get().getStudent().getStudentID(),
                studentInvitation.get().getStudentServiceMember().getStusluMemberID()
        );

        return studentInvitationDTO;

    }

    public SendInvitationAnswerDTO sendInvitationAnswer(SendInvitationAnswerDTO sendInvitationAnswerDTO) {

        Optional<StudentInvitation> studentInvitation = studentInvitationRepo.findById(sendInvitationAnswerDTO.getStudentInvitationID());

        if(!studentInvitation.isPresent()) {
            return null;
        }

        studentInvitation.get().setStudentText(sendInvitationAnswerDTO.getStudentText());
        studentInvitation.get().setStudentResponse(sendInvitationAnswerDTO.getStudentResponse());

        studentInvitationRepo.save(studentInvitation.get());
        return sendInvitationAnswerDTO;

    }
}
