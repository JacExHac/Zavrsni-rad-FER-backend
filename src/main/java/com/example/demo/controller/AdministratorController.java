package com.example.demo.controller;
import com.example.demo.DTOs.AdministratorDataDTO;
import com.example.demo.DTOs.PersonTBAByAdminDTO;
import com.example.demo.DTOs.StudentDataDTO;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.service.AdministratorService;
import com.example.demo.service.ExhibitionManagerService;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExhibitionManagerService exhibitionManagerService;

    @Autowired
    private StudentServiceMemberService studentServiceMemberService;

    @PostMapping("/login")
    public AdministratorDataDTO loginAdmin(@RequestBody UserDTO userDTO) {

        AdministratorDataDTO administratorDTO = administratorService.loginUser(userDTO.getUsername(), userDTO.getPassword());


        return administratorDTO;
    }

    @PostMapping("/addperson")
    public PersonTBAByAdminDTO addPerson(@RequestBody PersonTBAByAdminDTO personTBAByAdminDTO) {


        if(personTBAByAdminDTO.getRole().equals("student")) {

            return studentService.addStudent(personTBAByAdminDTO);
        }

        if(personTBAByAdminDTO.getRole().equals("stu-slu-member")) {
            return studentServiceMemberService.addStusluMember(personTBAByAdminDTO);
        }

        if(personTBAByAdminDTO.getRole().equals("exhibition-manager")) {
            return exhibitionManagerService.addExhManager(personTBAByAdminDTO);
        }

        return null;
    }

}
