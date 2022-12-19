package com.example.demo.controller;

import com.example.demo.DTOs.*;
import com.example.demo.service.ExhibitionManagerService;
import com.example.demo.service.StudentPosterRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/exhmanager")
public class ExhibitionManagerController {

    @Autowired
    private ExhibitionManagerService exhibitionManagerService;

    @Autowired
    private StudentPosterRequestService studentPosterRequestService;

    @GetMapping("/allmanagers")
    public List<ExhibitionManagerDTO> getAllManagers() {
        return exhibitionManagerService.getAllManagers();
    }

    @PostMapping("/login")
    public ExhibitionManagerDTO loginExhManager(@RequestBody UserDTO userDTO) {
        ExhibitionManagerDTO exhibitionManagerDTO = exhibitionManagerService.loginUser(userDTO.getUsername(), userDTO.getPassword());

        return exhibitionManagerDTO;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExhManager(@PathVariable(value = "id") long exhibitionManagerID) {
        exhibitionManagerService.deleteExhManager(exhibitionManagerID);
    }

    @PostMapping("/finalizestudentposterrequest")
    public void finalizeStudentPosterRequest(@RequestBody FinalizeStudentPosterRequestDTO finalizeStudentPosterRequestDTO) {
        studentPosterRequestService.acceptStudentPosterRequest(finalizeStudentPosterRequestDTO);
    }

    @PutMapping("/alterstudentposterrequest")
    public StudentPosterRequestDTO alterStudentPosterRequest(@RequestBody StudentPosterRequestDTO studentPosterRequestDTO) {

        if(studentPosterRequestService.updateStudentPosterRequest(studentPosterRequestDTO) != null) {
            return studentPosterRequestDTO;
        }

        return null;
    }
}
