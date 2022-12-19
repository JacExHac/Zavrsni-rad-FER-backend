package com.example.demo.repository;

import com.example.demo.model.ExhibitionManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExhibitionManagerRepo extends JpaRepository<ExhibitionManager,Long> {
    Optional<ExhibitionManager> findByUsername(String username);

    List<ExhibitionManager> findAllByOrderByExhibitionManagerIDDesc();
}
