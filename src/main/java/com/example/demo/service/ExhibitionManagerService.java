package com.example.demo.service;

import com.example.demo.DTOs.ExhibitionManagerDTO;
import com.example.demo.DTOs.PersonTBAByAdminDTO;
import com.example.demo.model.ExhibitionManager;
import com.example.demo.repository.ExhibitionManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionManagerService {

    @Autowired
    private ExhibitionManagerRepo exhibitionManagerRepo;

    public ExhibitionManagerDTO loginUser(String username, String password) {
        Optional<ExhibitionManager> exhibitionManager = exhibitionManagerRepo.findByUsername(username);
        ExhibitionManagerDTO exhibitionManagerDTO = new ExhibitionManagerDTO();

        if(!exhibitionManager.isPresent()) {
            return exhibitionManagerDTO;
        }

        ExhibitionManager existingExhibitionManager = exhibitionManager.get();

        if(!existingExhibitionManager.getPassword().equals(password)) {
            exhibitionManagerDTO.setErrorDuringLogin("Password mismatch");
            return exhibitionManagerDTO;
        }

        ExhibitionManagerDTO exhibitionManagerDTOSuccess = new ExhibitionManagerDTO(
                existingExhibitionManager.getExhibitionManagerID(),
                existingExhibitionManager.getName(),
                existingExhibitionManager.getSurname(),
                existingExhibitionManager.getUsername()
        );

        return exhibitionManagerDTOSuccess;

    }


    public PersonTBAByAdminDTO addExhManager(PersonTBAByAdminDTO personTBAByAdminDTO) {

        Optional<ExhibitionManager> exhibitionManagerOptionalByUsername = exhibitionManagerRepo.findByUsername(personTBAByAdminDTO.getUsername());

        if(exhibitionManagerOptionalByUsername.isPresent()) {
            PersonTBAByAdminDTO personTBReturned = new PersonTBAByAdminDTO();
            personTBReturned.setErrorMessage("Postoji voditelj izložbe s ovim korisničkim imenom...");
            return personTBReturned;
        }

        ExhibitionManager exhibitionManagerTBA = new ExhibitionManager(
                personTBAByAdminDTO.getName(),
                personTBAByAdminDTO.getSurname(),
                personTBAByAdminDTO.getPassword(),
                personTBAByAdminDTO.getUsername()
        );

        exhibitionManagerRepo.save(exhibitionManagerTBA);
        return personTBAByAdminDTO;
    }

    public List<ExhibitionManagerDTO> getAllManagers() {
        List<ExhibitionManagerDTO> exhibitionManagerDTOS = new ArrayList<>();

        for(ExhibitionManager exhibitionManager : exhibitionManagerRepo.findAllByOrderByExhibitionManagerIDDesc()) {
            exhibitionManagerDTOS.add(new ExhibitionManagerDTO(
                    exhibitionManager.getExhibitionManagerID(),
                    exhibitionManager.getName(),
                    exhibitionManager.getSurname(),
                    exhibitionManager.getUsername()
            ));
        }

        return exhibitionManagerDTOS;
    }

    public void deleteExhManager(long exhibitionManagerID) {
        Optional<ExhibitionManager> exhibitionManagerTBD = exhibitionManagerRepo.findById(exhibitionManagerID);

        if(!exhibitionManagerTBD.isPresent()) {
            return;
        }

        exhibitionManagerRepo.delete(exhibitionManagerTBD.get());
    }
}
