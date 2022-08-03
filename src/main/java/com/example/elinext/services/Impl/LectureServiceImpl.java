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

import java.time.LocalDateTime;
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
        groupService.existByGroupId(askRequestLectureDto.getGroupId());
        teacherService.existByTeacherSurname(askRequestLectureDto.getTeacherSurname());
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
            return "lecture with id" + id + " not exist";
        } else throw new NotFoundException(String.format("lecture with id" + id + "  not exist"));
    }

    @Override
    public List<Lecture> getAllByDaysOfWeekAndGroupId(DaysOfWeek daysOfWeek, Long groupId) {
        return lecturesRepo.findAllByDaysOfWeekAndAndGroupId(daysOfWeek, groupId);
    }

    @Override
    public LectureDto update(Long id, String name, DaysOfWeek daysOfWeek, Long groupId, LocalDateTime localDateTime) {
        Lecture lecture = lecturesRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Lecture with id" + id + " not exist")));
        if (!(name == null)) lecture.setName(name);
        if (!(daysOfWeek == null)) lecture.setDaysOfWeek(daysOfWeek);
        if (!(groupId == null)) lecture.setGroupId(groupId);
        if (!(localDateTime == null)) lecture.setLocalDateTime(localDateTime);
        lecturesRepo.save(lecture);
        return lectureMapper.lectureToLectureDto(lecture);
    }
}
