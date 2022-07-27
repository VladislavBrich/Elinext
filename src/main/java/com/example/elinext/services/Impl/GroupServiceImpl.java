package com.example.elinext.services.Impl;

import com.example.elinext.dto.GroupDto;
import com.example.elinext.exception.BadRequestException;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.mapper.GroupMapper;
import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import com.example.elinext.repositories.GroupsRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements com.example.elinext.services.GroupService {

    private GroupsRepo groupsRepo;

    private StudentServiceImpl studentService;

    private UniversityServiceImpl universityService;

    private GroupMapper groupMapper;


    @Override
    public void create(Long groupNumber, String universityName) {
        if (universityService.existsByUniversityName(universityName)) {
            throw new BadRequestException(String.format("University with that name \"%s\" is already exist", universityName));
        }
        Group group = new Group(groupNumber);
        groupsRepo.save(group);

    }

    @Override
    public List<Group> getAll() {
        List<Group> groups = groupsRepo.findAll();
        return groups;
    }

    @Override
    public Group getById(Long id) {
        Group group = groupsRepo.findById(id).orElseThrow(() -> new NotFoundException(String.format("Not Found")));
        return group;
    }

    public void delete(Long groupNumber, String universityName) {
        if (universityService.existsByUniversityName(universityName)) {
            throw new BadRequestException(String.format("University with that name \"%s\" is not exist", universityName));
        }
        if (groupsRepo.existsById(groupNumber)) {
            throw new BadRequestException(String.format("Group with that Number \"%s\" is not exist", universityName));
        }
    }
}

