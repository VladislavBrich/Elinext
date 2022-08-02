package com.example.elinext.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class TeacherDto {

    private Long id;
    private String teacherName;
    private String teacherSurname;

    private UniversityDto university;

    public TeacherDto(Long id, String teacherName, String teacherSurname, UniversityDto university) {
        this.id = id;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.university = university;
    }
}

