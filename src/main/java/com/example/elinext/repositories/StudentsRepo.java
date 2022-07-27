package com.example.elinext.repositories;


import com.example.elinext.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository

public interface StudentsRepo extends JpaRepository<Student, Long> {
     @Query(value = "SELECT n FROM Student n ORDER BY n.studentName,n.studentLastName")
    List<Student> findAllOrderByLastNameAndStudentName(String studentLastname);



}
