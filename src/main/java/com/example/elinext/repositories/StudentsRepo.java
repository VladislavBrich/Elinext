package com.example.elinext.repositories;


import com.example.elinext.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepo extends JpaRepository<Student, Long> {
    List<Student> findAllByStudentName (String studentName);
    List<Student> findAllByStudentLastName (String studentLastName);
    List<Student> findAllByGroupNumber (int groupNumber);

}
