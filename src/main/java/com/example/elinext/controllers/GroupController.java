package com.example.elinext.controllers;

import com.example.elinext.dto.*;
import com.example.elinext.models.Group;
import com.example.elinext.services.Impl.GroupServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/groups")
public class GroupController {

    private GroupServiceImpl groupService;


    @GetMapping("/university/{universityId}")
    public List<GroupDto> getAllGroups(@PathVariable Long universityId) {
        return groupService.getAll(universityId);
    }

    @PostMapping(value = "create")
    public GroupDto createGroupAtUniversity(@RequestBody AskRequestGroupDto askRequestGroupDto) {
        return groupService.create(askRequestGroupDto);
    }

    @GetMapping("{id}")
    public Group getGroupById(@PathVariable Long id) {
        return groupService.getById(id);
    }

    @DeleteMapping("delete/{universityId}/{groupId}")
    public AskDto deleteGroupByIdAndUniversityName(@PathVariable Long groupId, @PathVariable Long universityId) {
        groupService.delete(groupId, universityId);
        return AskDto.giveAnAnswer(true);
    }

    @GetMapping("students/{groupId}")
    public List<StudentDto> getAllStudentByGroupId(@PathVariable Long groupId) {
        return groupService.getAllStudentByGroupId(groupId);
    }

    @GetMapping("/lectures/{groupId}")
    public List<LectureDto> getLecturesByGroupId(@PathVariable Long groupId) {
        return groupService.getAllLecturesByGroupId(groupId);
    }

    @PostMapping("update/{id}")
    public GroupDto update(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "number") Long number) {
        return groupService.update(id, number);
    }
}

