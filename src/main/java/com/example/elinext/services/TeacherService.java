package com.example.elinext.services;

import com.example.elinext.dto.AskRequestTeacherDto;
import com.example.elinext.dto.TeacherDto;
import com.example.elinext.models.Teacher;

import java.util.List;

public interface TeacherService {

    Boolean existByTeacherSurname(String teacherSurname);

    Teacher getByTeacherSurname(String teacherSurname);

    TeacherDto createTeacher(AskRequestTeacherDto askRequestTeacherDto);

    List<TeacherDto> getAllByUniversityId (Long id);

    String deleteById(Long teacherId);

    TeacherDto update (Long id, String name, String surname);
}
