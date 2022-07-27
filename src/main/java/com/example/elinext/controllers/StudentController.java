package com.example.elinext.controllers;


import com.example.elinext.models.Student;
import com.example.elinext.services.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;


    @GetMapping("/{LastName}")
    public List<Student> getAllByLastName(@PathVariable String LastName) {
        List<Student> students = studentService.getAllByLastName(LastName);
        return students;
    }


}




