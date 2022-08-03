package com.example.elinext.services;

import com.example.elinext.dto.AskRequestStudentDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.dto.StudentDto;
import com.example.elinext.hellpers.DaysOfWeek;

import java.util.List;

public interface StudentService {

    StudentDto create(AskRequestStudentDto askRequestStudentDto);

    List<StudentDto> findAllByGroupId(Long groupId);

    List<StudentDto> getByLastName(String studentLastName);

    void deleteById(Long studentId);

    List<LectureDto> getLecturesByDayOfWeek(String studentLastName, DaysOfWeek daysOfWeek);

    StudentDto update(Long id, String name, String surname, Long groupId);
}
