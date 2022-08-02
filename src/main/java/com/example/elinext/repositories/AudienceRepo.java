package com.example.elinext.repositories;


import com.example.elinext.models.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AudienceRepo extends JpaRepository<Audience, Long> {


}

