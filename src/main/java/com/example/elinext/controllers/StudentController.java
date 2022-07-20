package com.example.elinext.controllers;


import com.example.elinext.models.Audience;
import com.example.elinext.models.Student;
import com.example.elinext.services.StudentServiceImpl;
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


    @GetMapping("/getByName/{name}")
    public List<Student> getAllByName(@PathVariable("name") String studentName) {
        List<Student> students = studentService.getByName(studentName);
        return students;
    }

    @GetMapping("/getByLastName/{LastName}")
    public List<Student> getAllByLastName(@PathVariable("LastName") String studentLastName) {
        List<Student> students = studentService.getByLastName(studentLastName);
        return students;
    }

    @GetMapping("/getByGroupName/{groupNumber}")
    public List<Student> getAlLByGroupNumber(@PathVariable("groupNumber") int groupNumber) {
        List<Student> students = studentService.getByGroupName(groupNumber);
        return students;
    }

    @GetMapping("/getTimetable/{studentName}")
    public List<Audience> getTimetableByGroupNumber(@PathVariable("studentName") String studentName) {
        List<Audience> timeTable = studentService.getTimetable(studentName);
        return timeTable;
    }
}

