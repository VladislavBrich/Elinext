package com.example.elinext.services.Impl;

import com.example.elinext.models.Group;
import com.example.elinext.models.Student;
import com.example.elinext.models.University;
import com.example.elinext.repositories.GroupsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements com.example.elinext.services.GroupService {
    @Autowired
    GroupsRepo groupsRepo;

    @Autowired
    StudentServiceImpl studentService;


    @Override
    public Group create(Integer groupNumber, University university) {
        Group group = groupsRepo
                .save(Group.makeDefault(groupNumber, university));
        return group;
    }
}

