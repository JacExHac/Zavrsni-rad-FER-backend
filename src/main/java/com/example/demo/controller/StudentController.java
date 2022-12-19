package com.example.demo.controller;


import com.example.demo.DTOs.*;
import com.example.demo.model.Poster;
import com.example.demo.model.Student;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentPosterRequestService studentPosterRequestService;

    @Autowired
    private PosterService posterService;

    @Autowired
    private StudentInvitationService studentInvitationService;

    @GetMapping("/home")
    public List<NotificationDTO> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/mydata/{id}")
    public StudentDataDTO getStudentData(@PathVariable(value = "id") long studentID) {
        StudentDataDTO studentDataDTO = studentService.getStudentData(studentID);

        return studentDataDTO;
    }

    @GetMapping("/poster/{id}")
    public PosterDataDTO getPosterInfo(@PathVariable(value = "id") long studentID) {

        //provjeri postoji li vec poster od tog studenta
        //ako postoji vrati sve informacije o njemu
        //ako ne postoji vrati null
        PosterDataDTO posterDataDTO = studentService.getPosterInfo(studentID);
        return studentService.getPosterInfo(studentID);
    }

    @GetMapping("/posterrequest/{id}")
    public StudentPosterRequestDTO getStudentPosterRequestInfo(@PathVariable(value ="id") long studentID) {
        StudentPosterRequestDTO studentPosterRequestDTO = studentPosterRequestService.getStudentPosterRequestData(studentID);
        return studentPosterRequestDTO;
    }

    @GetMapping("/allstudents")
    public List<StudentDataDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/sendposterrequest")
    public StudentPosterRequestDTO sendPosterRequest(@RequestBody StudentPosterRequestDTO studentPosterRequestDTO) {

        //student exists?
        Optional<Student> student = studentService.findStudent(studentPosterRequestDTO.getStudentID());

        if(!student.isPresent()) {
            return null;
        }

        if(studentPosterRequestService.saveStudentPosterRequest(studentPosterRequestDTO) != null) {
            return studentPosterRequestDTO;
        }

        return null;
    }

    @PostMapping("/addposter/{id}")
    public Poster addPosterForStudent(@RequestBody PosterDataDTO posterDataDTO) {
        //student exists?
        Optional<Student> student = studentService.findStudent(posterDataDTO.getStudentID());

        if(!student.isPresent()) {
            return null;
        }

        if(posterDataDTO.getImageURL().equals("")) {
            return null;
        }


        Poster poster = new Poster(posterDataDTO.getImageURL(), posterDataDTO.getPosterStatus(), student.get());

        return posterService.addPoster(poster);
    }

    @PostMapping("/login")
    public StudentDataDTO loginStudent(@RequestBody UserDTO userDTO) {

        StudentDataDTO student = studentService.loginUser(userDTO.getUsername(), userDTO.getPassword());

        return student;
    }

    @PutMapping("/updateposterrequest")
    public StudentPosterRequestDTO updateStudentPosterRequest(@RequestBody StudentPosterRequestDTO studentPosterRequestDTO) {


        //updateaj->ako nije null vrati ovaj zahtjev koji si i poslao, ako je null vrati null
        if(studentPosterRequestService.updateStudentPosterRequest(studentPosterRequestDTO) != null) {
            return studentPosterRequestDTO;
        }

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(value = "id") long studentID) {
        studentService.deleteStudent(studentID);
    }

    @GetMapping("/invitation/{id}")
    public StudentInvitationDTO getInvitation(@PathVariable(value = "id") long studentID) {
        return studentInvitationService.getInvitationByStudentID(studentID);
    }

    @PostMapping("/sendinvitationanswer")
    public SendInvitationAnswerDTO sendInvitationAnswer(@RequestBody SendInvitationAnswerDTO sendInvitationAnswerDTO) {

        if(studentInvitationService.sendInvitationAnswer(sendInvitationAnswerDTO) != null) {
            return sendInvitationAnswerDTO;
        }

        return null;
    }

}
