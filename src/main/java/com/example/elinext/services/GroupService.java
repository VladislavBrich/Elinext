package com.example.elinext.services;

import com.example.elinext.dto.GroupDto;
import com.example.elinext.mapper.GroupMapper;
import com.example.elinext.models.Group;
import com.example.elinext.models.Student;
import com.example.elinext.models.University;

import java.util.List;

public interface GroupService {


    GroupDto create(Long groupNumber, String universityId);

    List<GroupDto> getAll (Long universityId);

    Group getById (Long id);



}
