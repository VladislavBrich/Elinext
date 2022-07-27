package com.example.elinext.controllers;

import com.example.elinext.dto.AskDto;
import com.example.elinext.dto.GroupDto;

import com.example.elinext.models.Group;
import com.example.elinext.services.Impl.GroupServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private GroupServiceImpl groupService;


    @GetMapping()
    public List<Group> getAllGroups() {
        return groupService.getAll();
    }

    @PostMapping("create/{groupNumber}")
    public AskDto createGroup(@PathVariable Long groupNumber, @RequestBody String universityName) {
        groupService.delete(groupNumber, universityName);
        return AskDto.makeDefault(true);
    }

    @GetMapping("{id}")
    public Group getGroupById(@PathVariable Long id) {
        return groupService.getById(id);
    }

    @DeleteMapping("delete")
    public AskDto deleteGroupByIdAndUniversityName(@RequestBody Long groupId, @RequestBody String universityName) {
        groupService.delete(groupId, universityName);
        return AskDto.makeDefault(true);
    }
}
