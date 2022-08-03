package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestTeacherDto;
import com.example.elinext.dto.TeacherDto;
import com.example.elinext.exception.NotFoundException;
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
                askRequestTeacherDto.getName(),
                askRequestTeacherDto.getSurname(),
                university
        );
        teachersRepo.save(teacher);
        return teacherMapper.createTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllByUniversityId(Long universityId) {
        universityService.existsByUniversityId(universityId);
        List<Teacher> teachers = teachersRepo.getAllByUniversityId(universityId);
        return teacherMapper.createListTeacherDto(teachers);
    }

    @Override
    public String deleteById(Long teacherId) {
        teachersRepo.deleteById(teacherId);
        return "Teacher with id " + teacherId + " was deleted";
    }

    @Override
    public TeacherDto update(Long id, String name, String surname) {
        Teacher teacher = teachersRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Teacher with id " + id + " does not exist")));
        if (!(name == null)) {
            teacher.setTeacherName(name);
        }
        if (!(surname == null)) {
            teacher.setTeacherSurname(surname);
        }
        teachersRepo.save(teacher);
        return teacherMapper.createTeacherDto(teacher);
    }
}
