package com.example.elinext.repositories;

import com.example.elinext.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturesRepo extends JpaRepository<Lecture,Long> {
}
