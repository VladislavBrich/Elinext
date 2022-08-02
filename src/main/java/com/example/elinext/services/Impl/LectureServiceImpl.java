package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestLectureDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.exception.BadRequestException;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.hellpers.DaysOfWeek;
import com.example.elinext.mapper.LectureMapper;
import com.example.elinext.models.Group;
import com.example.elinext.models.Lecture;
import com.example.elinext.models.Teacher;
import com.example.elinext.repositories.LecturesRepo;
import com.example.elinext.services.LectureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LectureServiceImpl implements LectureService {

    private GroupServiceImpl groupService;
    private LecturesRepo lecturesRepo;
    private TeacherServiceImpl teacherService;
    private LectureMapper lectureMapper;

    @Override
    public LectureDto create(AskRequestLectureDto askRequestLectureDto) {
        if (!groupService.existByGroupId(askRequestLectureDto.getGroupId())) {
            throw new BadRequestException(String.format("group with that id \"%s\" is not exist",
                    askRequestLectureDto.getGroupId()));
        }
        if (!teacherService.existByTeacherSurname(askRequestLectureDto.getTeacherSurname())) {
            throw new BadRequestException(String.format("teacher with that name \"%s\" is not exist",
                    askRequestLectureDto.getTeacherSurname()));
        }
        Teacher teacher = teacherService.getByTeacherSurname(askRequestLectureDto.getTeacherSurname());
        Group group = groupService.getById(askRequestLectureDto.getGroupId());
        Lecture lecture = new Lecture(askRequestLectureDto.getLectureName(),
                askRequestLectureDto.getLocalDateTime(),
                askRequestLectureDto.getDaysOfWeek(), teacher, group);
        lecturesRepo.save(lecture);
        return lectureMapper.lectureToLectureDto(lecture);
    }

    @Override
    public String deleteById(Long id) {
        if (lecturesRepo.existsById(id)) {
            lecturesRepo.deleteById(id);
            return "lecture with id" + id + "is not exist";
        } else throw new NotFoundException(String.format("lecture with id" + id + "is not exist"));
    }

    @Override
    public List<Lecture> getAllByDaysOfWeekAndGroupId(DaysOfWeek daysOfWeek, Long groupId) {
        return lecturesRepo.findAllByDaysOfWeekAndAndGroupId(daysOfWeek, groupId);
    }
}
