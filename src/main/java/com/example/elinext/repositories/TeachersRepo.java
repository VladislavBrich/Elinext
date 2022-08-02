package com.example.elinext.repositories;

import com.example.elinext.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersRepo extends JpaRepository<Teacher, Long> {

    Boolean existsByTeacherSurname(String teacherSurname);

    Teacher getTeacherByTeacherSurname(String teacherSurname);

    List<Teacher> getAllByUniversityName(String universityName);
}
