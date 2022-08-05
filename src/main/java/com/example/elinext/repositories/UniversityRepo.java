package com.example.elinext.repositories;

import com.example.elinext.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {

    Boolean existsByName(String name);

    University findByName(String name);
}
