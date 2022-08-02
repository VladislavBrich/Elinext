package com.example.elinext.services;

import com.example.elinext.dto.AskRequestTeacherDto;
import com.example.elinext.dto.TeacherDto;
import com.example.elinext.models.Teacher;

import java.util.List;

public interface TeacherService {

    Boolean existByTeacherSurname(String teacherSurname);

    Teacher getByTeacherSurname(String teacherSurname);

    TeacherDto createTeacher(AskRequestTeacherDto askRequestTeacherDto);

    List<TeacherDto> getAllByUniversity(String universityName);

    String deleteById(Long teacherId);
}
