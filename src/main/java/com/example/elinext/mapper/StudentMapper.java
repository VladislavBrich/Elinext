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

    public StudentDto createUserDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getStudentName(),
                student.getStudentLastName(),
                groupMapper.groupToGroupDto(student.getGroup())
        );
    }

    public List<StudentDto> createStudentDtoList(List<Student> students) {
        return students.stream().map(this::createUserDto).collect(Collectors.toList());
    }
}
