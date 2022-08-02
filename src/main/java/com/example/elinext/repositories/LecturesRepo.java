package com.example.elinext.repositories;

import com.example.elinext.dto.LectureDto;
import com.example.elinext.hellpers.DaysOfWeek;
import com.example.elinext.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturesRepo extends JpaRepository<Lecture, Long> {

    List<Lecture> findAllByGroupId(Long groupId);

    List<Lecture> findAllByDaysOfWeekAndAndGroupId (DaysOfWeek daysOfWeek,Long groupId);
}
