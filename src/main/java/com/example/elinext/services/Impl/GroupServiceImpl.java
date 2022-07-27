package com.example.elinext.services.Impl;

import com.example.elinext.dto.GroupDto;
import com.example.elinext.exception.BadRequestException;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.mapper.GroupMapper;
import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import com.example.elinext.repositories.GroupsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements com.example.elinext.services.GroupService {

    private GroupsRepo groupsRepo;

    private StudentServiceImpl studentService;

    private UniversityServiceImpl universityService;

    private GroupMapper groupMapper;


    @Override
    public GroupDto create(Long groupNumber, String universityName) {
        if (!universityService.existsByUniversityName(universityName)) {
            throw new BadRequestException(String.format("University with that name \"%s\" is not exist", universityName));
        }
        University university = universityService.findByName(universityName);
        Group group = new Group(groupNumber, university);
        groupsRepo.save(group);
        return groupMapper.groupToGroupDto(group);

    }

    public List<GroupDto> getAll(Long universityId) {
        University university = universityService.findById(universityId);
        List<Group> groups = university.getGroups();
       return groupMapper.groupDtoList(groups);
    }

    @Override
    public Group getById(Long id) {
        Group group = groupsRepo.findById(id).orElseThrow(() -> new NotFoundException(String.format("Not Found")));
        return group;
    }

    public void delete(Long groupNumber, Long universityId) {
        if (universityService.existsByUniversityId(universityId)
                && groupsRepo.existsByGroupNumber(groupNumber)) {
            groupsRepo.deleteByGroupNumberAndUniversityId(groupNumber,universityId);
        }else throw new NotFoundException(String.format("Bad request"));


        }
    }


