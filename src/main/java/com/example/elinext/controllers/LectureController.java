package com.example.elinext.controllers;

import com.example.elinext.dto.AskRequestLectureDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.hellpers.DaysOfWeek;
import com.example.elinext.services.Impl.LectureServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "lecture", produces = MediaType.APPLICATION_JSON_VALUE)
public class LectureController {

    private final LectureServiceImpl lectureService;

    public LectureController(LectureServiceImpl lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("create")
    public LectureDto createLecture(@RequestBody AskRequestLectureDto askRequestLectureDto) {
        return lectureService.create(askRequestLectureDto);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return lectureService.deleteById(id);
    }

    @PostMapping("update/{id}")
    public LectureDto update(
            @PathVariable Long id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "days_of_week", required = false) DaysOfWeek daysOfWeek,
            @RequestParam(name = "groupId", required = false) Long groupId,
            @RequestParam(name = "data_time", required = false) LocalDateTime localDateTime) {
        return lectureService.update(id, name, daysOfWeek, groupId, localDateTime);
    }
}
