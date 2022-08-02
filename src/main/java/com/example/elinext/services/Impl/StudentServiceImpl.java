package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestStudentDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.dto.StudentDto;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.hellpers.DaysOfWeek;
import com.example.elinext.mapper.LectureMapper;
import com.example.elinext.mapper.StudentMapper;
import com.example.elinext.models.Group;
import com.example.elinext.models.Lecture;
import com.example.elinext.models.Student;
import com.example.elinext.repositories.StudentRepo;
import com.example.elinext.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;
    private GroupServiceImpl groupService;
    private StudentMapper studentMapper;
    private LectureMapper lectureMapper;

    private LectureServiceImpl lectureService;

    @Override
    public StudentDto create(AskRequestStudentDto askRequestStudentDto) {
        Group group = groupService.getById(askRequestStudentDto.getGroupId());
        Student student = new Student(
                askRequestStudentDto.getStudentName(),
                askRequestStudentDto.getStudentLastName(),
                group
        );
        studentRepo.save(student);
        return studentMapper.createUserDto(student);
    }

    @Override
    public List<StudentDto> findAllByGroupId(Long groupId) {
        groupService.getById(groupId);
        List<Student> students = studentRepo.findAllByGroupId(groupId);
        return studentMapper.createStudentDtoList(students);
    }

    @Override
    public List<StudentDto> getByLastName(String studentLastName) {
        List<Student> students = studentRepo.findAllByStudentLastName(studentLastName);
        return studentMapper.createStudentDtoList(students);
    }

    @Override
    public void deleteById(Long studentId) {
        if (studentRepo.existsById(studentId)) {
            studentRepo.deleteById(studentId);
        } else throw new NotFoundException(String.format("Student with id \"%s\" is not exist ", studentId));
    }

    @Override
    public List<LectureDto> getLecturesByDayOfWeek(String studentLastName, DaysOfWeek daysOfWeek) {
        if (studentRepo.existsByStudentLastName(studentLastName)) {
            Student student = studentRepo.findByStudentLastName(studentLastName);
            Group group = student.getGroup();
            List<Lecture> lectures = lectureService.getAllByDaysOfWeekAndGroupId(daysOfWeek, group.getId());
            lectureMapper.createListLectureDto(lectures);
            return lectureMapper.createListLectureDto(lectures);
        } else
            throw new NotFoundException(String.format("Student with studentLastName \"%s\" is not exist ", studentLastName));
    }
}








