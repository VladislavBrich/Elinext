package com.example.elinext.controllers;

import com.example.elinext.models.Student;
import com.example.elinext.services.Impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupServiceImpl groupService;

    @GetMapping("/students/{id}")
    public List<Student> getAllStudentByGroup (@PathVariable("id")Long id){
        return groupService.getAllStudents(id);
    }
}
