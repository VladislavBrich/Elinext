package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestTeacherDto;
import com.example.elinext.dto.TeacherDto;
import com.example.elinext.mapper.TeacherMapper;
import com.example.elinext.models.Teacher;
import com.example.elinext.models.University;
import com.example.elinext.repositories.TeachersRepo;
import com.example.elinext.services.TeacherService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class TeacherServiceImpl implements TeacherService {

    private TeachersRepo teachersRepo;
    private UniversityServiceImpl universityService;
    private TeacherMapper teacherMapper;

    @Override
    public Boolean existByTeacherSurname(String teacherSurname) {
        return teachersRepo.existsByTeacherSurname(teacherSurname);
    }

    @Override
    public Teacher getByTeacherSurname(String teacherSurname) {
        return teachersRepo.getTeacherByTeacherSurname(teacherSurname);
    }

    @Override
    public TeacherDto createTeacher(AskRequestTeacherDto askRequestTeacherDto) {
        University university = universityService.findByName(askRequestTeacherDto.getUniversityName());
        Teacher teacher = new Teacher(
                askRequestTeacherDto.getTeacherName(),
                askRequestTeacherDto.getTeacherSurname(),
                university
        );
        teachersRepo.save(teacher);
        return teacherMapper.createTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllByUniversity(String universityName) {
        universityService.existsByUniversityName(universityName);
        List<Teacher> teachers = teachersRepo.getAllByUniversityName(universityName);
        return teacherMapper.createListTeacherDto(teachers);
    }

    @Override
    public String deleteById(Long teacherId) {
        teachersRepo.deleteById(teacherId);
        return "Teacher with id " + teacherId + " was deleted";
    }
}
