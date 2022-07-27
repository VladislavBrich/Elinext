package com.example.elinext.services.Impl;

import com.example.elinext.models.Student;
import com.example.elinext.repositories.StudentsRepo;
import com.example.elinext.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentsService {
    @Autowired
    StudentsRepo studentsRepo;

    @Override
    public List<Student> getAllByLastName(String studentLastName) {
        List<Student> students = studentsRepo.findAllOrderByLastNameAndStudentName(studentLastName);
        return students;
    }

}






