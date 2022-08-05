package com.example.elinext.repositories;

import com.example.elinext.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersRepo extends JpaRepository<Teacher, Long> {

    Boolean existsBySurname(String teacherSurname);

    Teacher getTeacherBySurname(String teacherSurname);

    List<Teacher> getAllByUniversityId(Long universityId);
}
