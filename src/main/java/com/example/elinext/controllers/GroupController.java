package com.example.elinext.controllers;

import com.example.elinext.dto.AskDto;
import com.example.elinext.dto.AskRequestDto;
import com.example.elinext.dto.GroupDto;

import com.example.elinext.models.Group;
import com.example.elinext.services.Impl.GroupServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/groups",consumes = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    private GroupServiceImpl groupService;


    @GetMapping("/university/{universityId}")
    public List<GroupDto> getAllGroups(@PathVariable Long universityId) {
        return groupService.getAll(universityId);
    }

    @PostMapping(value = "create")
    public AskDto createGroup(@RequestBody AskRequestDto askRequestDto) {
        groupService.create(askRequestDto.getGroupNumber(), askRequestDto.getUniversityName());
        return AskDto.makeDefault(true);
    }

    @GetMapping("{id}")
    public Group getGroupById(@PathVariable Long id) {
        return groupService.getById(id);
    }

    @DeleteMapping("delete/{universityId}/{groupId}")
    public AskDto deleteGroupByIdAndUniversityName(@PathVariable Long groupId, @PathVariable Long universityId) {
        groupService.delete(groupId, universityId);
        return AskDto.makeDefault(true);
    }
}
