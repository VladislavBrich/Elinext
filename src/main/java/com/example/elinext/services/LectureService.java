package com.example.elinext.services;

import com.example.elinext.dto.AskRequestLectureDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.hellpers.DaysOfWeek;
import com.example.elinext.models.Lecture;

import java.util.List;

public interface LectureService {

    LectureDto create (AskRequestLectureDto askRequestLectureDto);

    String deleteById (Long id);

    List<Lecture> getAllByDaysOfWeekAndGroupId (DaysOfWeek daysOfWeek, Long groupId);
}
