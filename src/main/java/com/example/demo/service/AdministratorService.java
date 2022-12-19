package com.example.demo.service;

import com.example.demo.DTOs.AdministratorDataDTO;
import com.example.demo.DTOs.StudentDataDTO;
import com.example.demo.model.Administrator;
import com.example.demo.model.Student;
import com.example.demo.repository.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepo adminRepo;

    public AdministratorDataDTO loginUser(String username, String password) {
        Optional<Administrator> administrator = adminRepo.findByUsername(username);
        AdministratorDataDTO administratorDataDTO = new AdministratorDataDTO();

        if(!administrator.isPresent()) {
            return administratorDataDTO;
        }

        Administrator existingAdministrator = administrator.get();

        if(!existingAdministrator.getPassword().equals(password)) {
            administratorDataDTO.setErrorDuringLogin("Password mismatch");
            return administratorDataDTO;
        }

        AdministratorDataDTO administratorDataDTOSuccess = new AdministratorDataDTO(
                existingAdministrator.getAdministratorID(),
                existingAdministrator.getUsername());

        return administratorDataDTOSuccess;

    }

}
