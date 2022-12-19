package com.example.demo.service;


import com.example.demo.DTOs.FinalizeStudentPosterRequestDTO;
import com.example.demo.DTOs.StudentPosterRequestDTO;
import com.example.demo.model.Poster;
import com.example.demo.model.Student;
import com.example.demo.model.StudentPosterRequest;
import com.example.demo.repository.PosterRepo;
import com.example.demo.repository.StudentPosterRequestRepo;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class StudentPosterRequestService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentPosterRequestRepo studentPosterRequestRepo;

    @Autowired
    private PosterRepo posterRepo;

    public StudentPosterRequest saveStudentPosterRequest(StudentPosterRequestDTO studentPosterRequestDTO) {
        Optional<Student> student = studentService.findStudent(studentPosterRequestDTO.getStudentID());

        if(!student.isPresent()) {
            return null;
        }

        Optional<StudentPosterRequest> searchingForPosterRequest = studentPosterRequestRepo.findByStudent(student.get());

        if(searchingForPosterRequest.isPresent()) {
            return null;
        }

        Optional<Poster> searchingForPoster = posterRepo.findPosterByStudent(student.get());

        if(!searchingForPoster.isPresent()) {
            return null;
        }


        StudentPosterRequest studentPosterRequest = new StudentPosterRequest(
                student.get(),
                studentPosterRequestDTO.getNumOfChange(),
                studentPosterRequestDTO.getManagerComment(),
                studentPosterRequestDTO.getLastEditedBy(),
                studentPosterRequestDTO.getStudentComment()

        );

        searchingForPoster.get().setPosterStatus("pending");

        StudentPosterRequest studentPosterRequestFromDB = studentPosterRequestRepo.save(studentPosterRequest);
        posterRepo.save(searchingForPoster.get());
        return studentPosterRequestRepo.save(studentPosterRequest);
    }

    public StudentPosterRequestDTO getStudentPosterRequestData(Long studentID) {

        Optional<Student> studentOptional = studentRepo.findById(studentID);

        if(!studentOptional.isPresent()) {
            return null;
        }

        Optional<StudentPosterRequest> studentPosterRequestOptional = studentPosterRequestRepo.findByStudent(studentOptional.get());

        if(!studentPosterRequestOptional.isPresent()) {
            return null;
        }

        Student workingStudent = studentOptional.get();
        StudentPosterRequest studentPosterRequest = studentPosterRequestOptional.get();

        Optional<Poster> posterOptional = posterRepo.findPosterByStudent(workingStudent);

        if(!posterOptional.isPresent()) {
            return null;
        }




        StudentPosterRequestDTO studentPosterRequestDTO = new StudentPosterRequestDTO(
                studentID,
                workingStudent.getJMBAG(),
                workingStudent.getName(),
                workingStudent.getSurname(),
                studentPosterRequest.getNumOfChange(),
                studentPosterRequest.getManagerComment(),
                studentPosterRequest.getLastEditedBy(),
                studentPosterRequest.getStudentComment(),
                posterOptional.get().getImageURL()
        );

        return studentPosterRequestDTO;

    }

    public StudentPosterRequest updateStudentPosterRequest(StudentPosterRequestDTO studentPosterRequestDTO) {

        Optional<Student> student = studentRepo.findById(studentPosterRequestDTO.getStudentID());

        if(!student.isPresent()) {
            return null;
        }

        Optional<StudentPosterRequest> studentPosterRequestOptional = studentPosterRequestRepo.findByStudent(student.get());

        if(!studentPosterRequestOptional.isPresent()) {
            return null;
        }

        StudentPosterRequest studentPosterRequestToBeUpdated = studentPosterRequestOptional.get();

        studentPosterRequestToBeUpdated.setStudentComment(studentPosterRequestDTO.getStudentComment());
        studentPosterRequestToBeUpdated.setManagerComment(studentPosterRequestDTO.getManagerComment());
        studentPosterRequestToBeUpdated.setLastEditedBy(studentPosterRequestDTO.getLastEditedBy());
        studentPosterRequestToBeUpdated.setNumOfChange(studentPosterRequestDTO.getNumOfChange());

        return studentPosterRequestRepo.save(studentPosterRequestToBeUpdated);


    }

    public void acceptStudentPosterRequest(FinalizeStudentPosterRequestDTO finalizeStudentPosterRequestDTO) {
        Optional<Student> studentOptional = studentRepo.findById(finalizeStudentPosterRequestDTO.getStudentID());

        if(!studentOptional.isPresent()) {
            return;
        }

        Optional<StudentPosterRequest> studentPosterRequestOptional = studentPosterRequestRepo.findByStudent(studentOptional.get());

        if(!studentPosterRequestOptional.isPresent()) {
            return;
        }

        Optional<Poster> posterOptional = posterRepo.findPosterByStudent(studentOptional.get());

        if(!posterOptional.isPresent()) {
            return;
        }

        Poster acceptedPosterDataTBA = new Poster(
                posterOptional.get().getImageURL(),
                finalizeStudentPosterRequestDTO.getPosterStatus(),
                studentOptional.get()
        );

        posterRepo.save(acceptedPosterDataTBA);
        studentPosterRequestRepo.delete(studentPosterRequestOptional.get());
        return;

    }
}
