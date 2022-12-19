package com.example.demo.controller;

import com.example.demo.DTOs.*;
import com.example.demo.service.NotificationService;
import com.example.demo.service.StudentServiceMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stuslu")
public class StudentServiceMemberController {

    @Autowired
    private StudentServiceMemberService stuSluService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/allmembers")
    private List<StudentServiceMemberDTO> getAllMembers() {
        return stuSluService.getAllMembers();
    }

    @PostMapping("/login")
    public StudentServiceMemberDTO loginStuSluMember(@RequestBody UserDTO userDTO) {

        StudentServiceMemberDTO stuSluDTO = stuSluService.loginUser(userDTO.getUsername(), userDTO.getPassword());

        return stuSluDTO;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStuSluMember(@PathVariable(value = "id") long stusluMemberID) {
        stuSluService.deleteStuSluMember(stusluMemberID);
    }

    @DeleteMapping("/deletenotif/{id}")
    public void deleteNotif(@PathVariable(value = "id") long notificationID) {
        notificationService.deleteNotification(notificationID);
    }

    @PostMapping("/addnotif")
    public NotificationDTO addNotif(@RequestBody NotificationDTO notificationDTO) {

        if(notificationService.addNotification(notificationDTO) != null) {
            return notificationDTO;
        }
        return null;

    }

    @PostMapping("/invitestudent")
    public StudentInvitationDTO addStudentPosterRequest(@RequestBody StudentInvitationDTO studentInvitationDTO) {
        if(stuSluService.addStudentInvitation(studentInvitationDTO) != null) {
            return studentInvitationDTO;
        }

        return null;
    }

    @GetMapping("/allinvitations")
    public List<StudentInvitationDTO> getAllNotifications() {
        return stuSluService.getAllInvitations();
    }

    @PostMapping("/finalizestudentinvitation")
    public FinalizeStudentInviationDTO finalizeStudentInvitation(@RequestBody FinalizeStudentInviationDTO finalizeStudentInviationDTO) {
        if(stuSluService.finalizeStudentInvitation(finalizeStudentInviationDTO) != null) {
            return finalizeStudentInviationDTO;
        }

        return null;
    }
}
