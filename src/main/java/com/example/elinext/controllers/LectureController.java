package com.example.elinext.controllers;

import com.example.elinext.dto.AskRequestLectureDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.services.Impl.LectureServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "lecture",produces = MediaType.APPLICATION_JSON_VALUE)
public class LectureController {

    private final LectureServiceImpl lectureService;

    public LectureController(LectureServiceImpl lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("create")
    public LectureDto createLecture (@RequestBody AskRequestLectureDto askRequestLectureDto){
        return  lectureService.create(askRequestLectureDto);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById (@PathVariable Long id){
       return lectureService.deleteById(id);
    }
}
