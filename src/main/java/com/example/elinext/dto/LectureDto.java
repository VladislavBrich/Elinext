package com.example.elinext.dto;

import com.example.elinext.hellpers.DaysOfWeek;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LectureDto {
    private Long id;
    private String lectureName;
    private GroupDto group;
    private TeacherDto teacherDto;
    private DaysOfWeek daysOfWeek;
    private LocalDateTime localDateTime;

    public LectureDto(Long id, String lectureName, GroupDto group, TeacherDto teacherDto, DaysOfWeek daysOfWeek, LocalDateTime localDateTime) {
        this.id = id;
        this.lectureName = lectureName;
        this.group = group;
        this.teacherDto = teacherDto;
        this.daysOfWeek = daysOfWeek;
        this.localDateTime = localDateTime;
    }
}


