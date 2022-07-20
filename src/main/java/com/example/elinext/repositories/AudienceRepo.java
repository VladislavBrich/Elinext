package com.example.elinext.repositories;


import com.example.elinext.models.Audience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AudienceRepo extends JpaRepository<Audience, Long> {

    List<Audience> findAudiencesByStudentName (String studentName);

}

