package com.example.demo.service;


import com.example.demo.DTOs.FinalizeStudentInviationDTO;
import com.example.demo.DTOs.PersonTBAByAdminDTO;
import com.example.demo.DTOs.StudentInvitationDTO;
import com.example.demo.DTOs.StudentServiceMemberDTO;
import com.example.demo.model.*;
import com.example.demo.repository.NotificationRepo;
import com.example.demo.repository.StudentInvitationRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.StudentServiceMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class StudentServiceMemberService {

    @Autowired
    private StudentServiceMemberRepo stuSluRepo;

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private StudentInvitationRepo studentInvitationRepo;

    @Autowired
    private StudentRepo studentRepo;



    public StudentServiceMemberDTO loginUser(String username, String password) {
        Optional<StudentServiceMember> studentServiceMember = stuSluRepo.findByUsername(username);
        StudentServiceMemberDTO studentServiceMemberDTO = new StudentServiceMemberDTO();

        if(!studentServiceMember.isPresent()) {
            return studentServiceMemberDTO;
        }

        StudentServiceMember existingStudentServiceMember = studentServiceMember.get();

        if(!existingStudentServiceMember.getPassword().equals(password)) {
            studentServiceMemberDTO.setErrorDuringLogin("Password mismatch");
            return studentServiceMemberDTO;
        }

        StudentServiceMemberDTO studentServiceMemberDTOSuccess = new StudentServiceMemberDTO(
                existingStudentServiceMember.getStusluMemberID(),
                existingStudentServiceMember.getName(),
                existingStudentServiceMember.getSurname(),
                existingStudentServiceMember.getUsername()
        );

        return studentServiceMemberDTOSuccess;
    }

    public PersonTBAByAdminDTO addStusluMember(PersonTBAByAdminDTO personTBAByAdminDTO) {

        Optional<StudentServiceMember> studentServiceMemberOptionalByUsername = stuSluRepo.findByUsername(personTBAByAdminDTO.getUsername());

        if(studentServiceMemberOptionalByUsername.isPresent()) {
            PersonTBAByAdminDTO personTBReturned = new PersonTBAByAdminDTO();
            personTBReturned.setErrorMessage("Postoji član studentske službe s ovim korisničkim imenom...");
            return personTBReturned;
        }

        StudentServiceMember studentServiceMemberTBA = new StudentServiceMember(
                personTBAByAdminDTO.getName(),
                personTBAByAdminDTO.getSurname(),
                personTBAByAdminDTO.getPassword(),
                personTBAByAdminDTO.getUsername()
        );

        stuSluRepo.save(studentServiceMemberTBA);
        return personTBAByAdminDTO;

    }

    public List<StudentServiceMemberDTO> getAllMembers() {
        List<StudentServiceMemberDTO> studentServiceMemberDTOS = new ArrayList<>();

        for(StudentServiceMember studentServiceMember : stuSluRepo.findAllByOrderByStusluMemberIDDesc()) {
            studentServiceMemberDTOS.add(new StudentServiceMemberDTO(
                    studentServiceMember.getStusluMemberID(),
                    studentServiceMember.getName(),
                    studentServiceMember.getSurname(),
                    studentServiceMember.getUsername()
            ));
        }
        return studentServiceMemberDTOS;
    }

    public void deleteStuSluMember(long stusluMemberID) {
        Optional<StudentServiceMember> studentServiceMemberTBD = stuSluRepo.findById(stusluMemberID);

        if(!studentServiceMemberTBD.isPresent()) {
            return;
        }

        List<Notification> notificationList = notificationRepo.findAllByStudentServiceMember(studentServiceMemberTBD.get());

        for(Notification notif : notificationList) {
            notificationRepo.delete(notif);
        }

        List<StudentInvitation> studentInvitationList = studentInvitationRepo.findAllByStudentServiceMember(studentServiceMemberTBD.get());

        for(StudentInvitation studentInvitation : studentInvitationList) {
            studentInvitationRepo.delete(studentInvitation);
        }

        stuSluRepo.delete(studentServiceMemberTBD.get());


    }

    public StudentInvitationDTO addStudentInvitation(StudentInvitationDTO studentInvitation) {
        Optional<Student> student = studentRepo.findById(studentInvitation.getStudentID());

        if(!student.isPresent()) {
            return null;
        }

        Optional<StudentServiceMember> stusluMember = stuSluRepo.findById(studentInvitation.getStusluMemberID());

        if(!stusluMember.isPresent()) {
            return null;
        }

        StudentInvitation studentInvitationTBA = new StudentInvitation(
                student.get(),
                stusluMember.get()
        );

        student.get().setStudentStatus("invited");

        studentRepo.save(student.get());
        studentInvitationRepo.save(studentInvitationTBA);

        return studentInvitation;
    }

    public List<StudentInvitationDTO> getAllInvitations() {
        List<StudentInvitationDTO> studentInvitationDTOS = new ArrayList<>();

        for(StudentInvitation studentInvitation : studentInvitationRepo.findAll()) {
            StudentInvitationDTO studentInvitationDTO = new StudentInvitationDTO(
                    studentInvitation.getStudentInvitationID(),
                    studentInvitation.getStudentResponse(),
                    studentInvitation.getStudentText(),
                    studentInvitation.getStudent().getStudentID(),
                    studentInvitation.getStudentServiceMember().getStusluMemberID(),
                    studentInvitation.getStudent().getJMBAG()
            );
            studentInvitationDTOS.add(studentInvitationDTO);
        }

        return studentInvitationDTOS;
    }

    public FinalizeStudentInviationDTO finalizeStudentInvitation(FinalizeStudentInviationDTO finalizeStudentInviationDTO) {

        Optional<Student> student = studentRepo.findById(finalizeStudentInviationDTO.getStudentID());

        if(!student.isPresent()) {
            return null;
        }

        Optional<StudentInvitation> studentInvitation = studentInvitationRepo.findById(finalizeStudentInviationDTO.getStudentInvitationID());

        if(!student.isPresent()) {
            return null;
        }

        student.get().setStudentStatus(finalizeStudentInviationDTO.getStudentStatus());
        studentRepo.save(student.get());


        studentInvitationRepo.delete(studentInvitation.get());
        return finalizeStudentInviationDTO;

    }
}
