package com.example.elinext.mapper;

import com.example.elinext.dto.TeacherDto;
import com.example.elinext.models.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Data
public class TeacherMapper {
    UniversityMapper universityMapper;

   public TeacherDto createTeacherDto(Teacher teacher) {
        return new TeacherDto(
                teacher.getId(),
                teacher.getName(),
                teacher.getSurname(),
                universityMapper.universityToUniversityDto(teacher.getUniversity())
        );
    }
    public List<TeacherDto> createListTeacherDto (List<Teacher> teachers){
       return teachers.stream().map(this::createTeacherDto).collect(Collectors.toList());
    }
}
