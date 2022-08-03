package com.example.elinext.mapper;


import com.example.elinext.dto.LectureDto;
import com.example.elinext.models.Lecture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class LectureMapper {

    private GroupMapper groupMapper;

    private TeacherMapper teacherMapper;


    public LectureDto lectureToLectureDto(Lecture lecture) {
        return new LectureDto(
                lecture.getId(),
                lecture.getName(),
                groupMapper.groupDtoForLecture(lecture.getGroup()),
                teacherMapper.createTeacherDto(lecture.getTeacher()),
                lecture.getDaysOfWeek(),
                lecture.getLocalDateTime()
        );
    }

    public List<LectureDto> createListLectureDto(List<Lecture> lectures) {
        return lectures.stream().map(this::lectureToLectureDto).collect(Collectors.toList());
    }
}

