package com.example.elinext.controllers;

import com.example.elinext.dto.AskRequestTeacherDto;
import com.example.elinext.dto.TeacherDto;
import com.example.elinext.services.Impl.TeacherServiceImpl;
import lombok.AllArgsConstructor;
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

    @GetMapping("{universityId}")
    public List<TeacherDto> getAllTeacherByUniversity(@PathVariable Long universityId) {
        return teacherService.getAllByUniversityId(universityId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeacherById(@PathVariable Long id) {
        return teacherService.deleteById(id);
    }

    @PostMapping("update/{id}")
    public TeacherDto update(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname) {
        return teacherService.update(id, name, surname);
    }
}


