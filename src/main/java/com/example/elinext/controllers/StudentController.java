package com.example.elinext.controllers;


import com.example.elinext.dto.AskDto;
import com.example.elinext.dto.AskRequestStudentDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.dto.StudentDto;
import com.example.elinext.hellpers.DaysOfWeek;
import com.example.elinext.services.Impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private StudentServiceImpl studentService;

    @PostMapping("create")
    public StudentDto createStudentAtGroup(@RequestBody AskRequestStudentDto askRequestStudentDto) {
        return studentService.create(askRequestStudentDto);
    }

    @GetMapping("{lastName}")
    public List<StudentDto> getStudentByLastName(@PathVariable String lastName) {
        return studentService.getByLastName(lastName);
    }

    @DeleteMapping("delete/{studentId}")
    public AskDto deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteById(studentId);
        return AskDto.giveAnAnswer(true);
    }

    @GetMapping("{surname}/{daysOfWeek}")
    List<LectureDto> getLecturesForStudentByDayOfWeek(
            @PathVariable String surname,
            @PathVariable DaysOfWeek daysOfWeek) {
        return studentService.getLecturesByDayOfWeek(surname, daysOfWeek);
    }

    @PostMapping("update/{id}")
    public StudentDto update(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Long groupId) {
        return studentService.update(id, name, surname, groupId);
    }
}





