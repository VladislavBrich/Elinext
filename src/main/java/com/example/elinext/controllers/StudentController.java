package com.example.elinext.controllers;


import com.example.elinext.dto.AskRequestStudentDto;
import com.example.elinext.dto.StudentDto;
import com.example.elinext.services.Impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "student",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private StudentServiceImpl studentService;

    @PostMapping("create")
    public StudentDto createStudentAtGroup(@RequestBody AskRequestStudentDto askRequestStudentDto) {
        return studentService.create(askRequestStudentDto);
    }
    @GetMapping("{lastName}")
    public List<StudentDto> getStudentByLastName (@PathVariable String lastName){
        return studentService.getByLastName(lastName);
    }
}




