package com.example.demo.service;


import com.example.demo.DTOs.StudentPosterRequestDTO;
import com.example.demo.model.Poster;
import com.example.demo.model.Student;
import com.example.demo.model.StudentPosterRequest;
import com.example.demo.repository.PosterRepo;
import com.example.demo.repository.StudentPosterRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PosterService {

    @Autowired
    private PosterRepo posterRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentPosterRequestRepo studentPosterRequestRepo;

    public Poster addPoster(Poster poster) {
        Optional<Poster> searchingForPoster = posterRepo.findPosterByImageURL(poster.getImageURL());

        if(searchingForPoster.isPresent()) {
            return null;
        }

        return posterRepo.save(poster);
    }





}
