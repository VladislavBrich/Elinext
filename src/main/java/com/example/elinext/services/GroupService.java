package com.example.elinext.services;

import com.example.elinext.dto.AskRequestGroupDto;
import com.example.elinext.dto.GroupDto;
import com.example.elinext.dto.StudentDto;
import com.example.elinext.models.Group;

import java.util.List;

public interface GroupService {


    GroupDto create(AskRequestGroupDto askRequestGroupDto);

    List<GroupDto> getAll(Long universityId);

    Group getById(Long id);

    List<StudentDto> getAllStudentByGroupId(Long GroupId);

}
