package com.example.demo.service;


import com.example.demo.DTOs.PersonTBAByAdminDTO;
import com.example.demo.DTOs.PosterDataDTO;
import com.example.demo.DTOs.StudentDataDTO;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.model.Poster;
import com.example.demo.model.Student;
import com.example.demo.model.StudentInvitation;
import com.example.demo.model.StudentPosterRequest;
import com.example.demo.repository.PosterRepo;
import com.example.demo.repository.StudentInvitationRepo;
import com.example.demo.repository.StudentPosterRequestRepo;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    PosterRepo posterRepo;

    @Autowired
    StudentInvitationRepo studentInvitationRepo;

    @Autowired
    StudentPosterRequestRepo studentPosterRequestRepo;




    public StudentDataDTO getStudentData(Long studentID) {
        Optional<Student> student = studentRepo.findById(studentID);

        if(!student.isPresent()) {
            return null;
        }

        Student studentTBG = student.get();

        Optional<Poster> poster = posterRepo.findPosterByStudent(studentTBG);


        StudentDataDTO studentDataDTO = new StudentDataDTO(
                studentID,
                studentTBG.getName(),
                studentTBG.getSurname(),
                studentTBG.getJMBAG(),
                studentTBG.getStudentStatus(),
                studentTBG.getUsername(),
                poster.isPresent() ? poster.get().getImageURL() : null,
                poster.isPresent() ? poster.get().getPosterStatus() : null
        );
        return studentDataDTO;

    }

    public Optional<Student> findStudent(Long studentID) {
        return studentRepo.findById(studentID);
    }

    public PosterDataDTO getPosterInfo(Long studentID) {
        Optional<Student> student = studentRepo.findById(studentID);

        if(!student.isPresent()) {
            return null;
        }
        Optional<Poster> poster = posterRepo.findPosterByStudent(student.get());

        if(!poster.isPresent()) {
            return null;
        }
        PosterDataDTO posterDataDTO = new PosterDataDTO(
                poster.get().getImageURL(),
                poster.get().getPosterStatus(),
                poster.get().getStudent().getStudentID()
        );
        return posterDataDTO;
    }

    public StudentDataDTO loginUser(String username, String password) {
        Optional<Student> student = studentRepo.findByUsername(username);
        StudentDataDTO studentDataDTO = new StudentDataDTO();

        if(!student.isPresent()) {
            return studentDataDTO;
        }
        Student existingStudent = student.get();


        if(!existingStudent.getPassword().equals(password)) {
            studentDataDTO.setErrorDuringLogin("Password mismatch");
            return studentDataDTO;
        }

        StudentDataDTO studentDataDTOSuccess = new StudentDataDTO(
                existingStudent.getStudentID(),
                existingStudent.getName(),
                existingStudent.getSurname(),
                existingStudent.getJMBAG(),
                existingStudent.getStudentStatus(),
                existingStudent.getUsername());


        return studentDataDTOSuccess;
    }

    public PersonTBAByAdminDTO addStudent(PersonTBAByAdminDTO personTBAByAdminDTO) {

        Optional<Student> studentOptionalByUsername = studentRepo.findByUsername(personTBAByAdminDTO.getUsername());

        if(studentOptionalByUsername.isPresent()) {
            PersonTBAByAdminDTO personTBReturned = new PersonTBAByAdminDTO();
            personTBReturned.setErrorMessage("Postoji student s tim korisničkim imenom...");
            return personTBReturned;
        }

        Optional<Student> studentOptionalByJMBAG = studentRepo.findByJMBAG(personTBAByAdminDTO.getJMBAG());
        if(studentOptionalByJMBAG.isPresent()) {
            PersonTBAByAdminDTO personTBReturned = new PersonTBAByAdminDTO();
            personTBReturned.setErrorMessage("Postoji student s tim JMBAGOM...");
            return personTBReturned;
        }

        Student studentTBA = new Student(
                personTBAByAdminDTO.getName(),
                personTBAByAdminDTO.getSurname(),
                personTBAByAdminDTO.getJMBAG(),
                "created",
                personTBAByAdminDTO.getPassword(),
                personTBAByAdminDTO.getUsername()
        );

        studentRepo.save(studentTBA);
        return personTBAByAdminDTO;
    }

    public List<StudentDataDTO> getAllStudents() {
        List<StudentDataDTO> allStudentsList = new ArrayList<>();

        for(Student student : studentRepo.findAllByOrderByStudentIDDesc()) {
            Optional<Poster> poster = posterRepo.findPosterByStudent(student);

            StudentDataDTO studentDataDTOTBA;

            if(poster.isPresent()) {
                studentDataDTOTBA = (new StudentDataDTO(
                        student.getStudentID(),
                        student.getName(),
                        student.getSurname(),
                        student.getJMBAG(),
                        student.getStudentStatus(),
                        student.getUsername(),
                        poster.get().getPosterStatus()
                ));
            } else {
                studentDataDTOTBA = (new StudentDataDTO(
                        student.getStudentID(),
                        student.getName(),
                        student.getSurname(),
                        student.getJMBAG(),
                        student.getStudentStatus(),
                        student.getUsername()
                ));
            }

            Optional<StudentPosterRequest> studentPosterRequestOptional = studentPosterRequestRepo.findByStudent(student);

            if(studentPosterRequestOptional.isPresent()) {
                studentDataDTOTBA.setHasStudentPosterRequest(true);
            }

            allStudentsList.add(studentDataDTOTBA);
        }

        return allStudentsList;
    }

    public void deleteStudent(long studentID) {
        Optional<Student> student = studentRepo.findById(studentID);

        if(!student.isPresent()) {
            return;
        }

        Optional<Poster> posterTBD = posterRepo.findPosterByStudent(student.get());

        if(posterTBD.isPresent()) {
            posterRepo.delete(posterTBD.get());
        }

        Optional<StudentPosterRequest> studentPosterRequestTBD = studentPosterRequestRepo.findByStudent(student.get());

        if(studentPosterRequestTBD.isPresent()) {
            studentPosterRequestRepo.delete(studentPosterRequestTBD.get());
        }

        Optional<StudentInvitation> studentInvitationTBD = studentInvitationRepo.findByStudent(student.get());

        if(studentInvitationTBD.isPresent()) {
            studentInvitationRepo.delete(studentInvitationTBD.get());
        }

       studentRepo.delete(student.get());
    }
}
