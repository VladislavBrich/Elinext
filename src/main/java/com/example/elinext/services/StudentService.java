package com.example.elinext.services;

import com.example.elinext.dto.AskRequestStudentDto;
import com.example.elinext.dto.StudentDto;
import com.example.elinext.models.Student;

import java.util.List;

public interface StudentService {


    StudentDto create(AskRequestStudentDto askRequestStudentDto);

    List<StudentDto> findAllByGroupId(Long groupId);

    List<StudentDto> getByLastName (String studentLastName);


}
