package com.example.demo.repository;

import com.example.demo.model.Poster;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PosterRepo extends JpaRepository<Poster, String> {
    Optional<Poster> findPosterByStudent(Student student);

    Optional<Poster> findPosterByImageURL(String imageURL);

}
