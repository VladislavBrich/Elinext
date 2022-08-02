package com.example.elinext.controllers;

import com.example.elinext.dto.AskRequestTeacherDto;
import com.example.elinext.dto.TeacherDto;
import com.example.elinext.services.Impl.TeacherServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "teacher", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherController {

    private TeacherServiceImpl teacherService;

    @PostMapping("create")
    public TeacherDto createTeacher(@RequestBody AskRequestTeacherDto askRequestTeacherDto) {
        return teacherService.createTeacher(askRequestTeacherDto);
    }

    @GetMapping("{universityName}")
    public List<TeacherDto> getAllTeacherByUniversity(@PathVariable String universityName) {
        return teacherService.getAllByUniversity(universityName);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeacherById(@PathVariable Long id) {
        return teacherService.deleteById(id);
    }
}
