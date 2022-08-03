package com.example.elinext.mapper;

import com.example.elinext.dto.StudentDto;
import com.example.elinext.models.Student;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class StudentMapper {
    private GroupMapper groupMapper;

    public StudentMapper(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    public StudentDto createStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getSurname(),
                groupMapper.groupToGroupDto(student.getGroup())
        );
    }

    public List<StudentDto> createStudentDtoList(List<Student> students) {
        return students.stream().map(this::createStudentDto).collect(Collectors.toList());
    }
}
