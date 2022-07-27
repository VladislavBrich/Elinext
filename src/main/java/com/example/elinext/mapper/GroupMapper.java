package com.example.elinext.mapper;

import com.example.elinext.dto.GroupDto;
import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    private UniversityMapper universityMapper;

    public GroupMapper(UniversityMapper universityMapper) {
        this.universityMapper = universityMapper;
    }

    public GroupDto groupToGroupDto(Group group) {
        return new GroupDto(group.getId(),
                group.getGroupNumber(),universityMapper.universityToUniversityDto(group.getUniversity()));
    }

    public List<GroupDto> groupDtoList(List<Group> groups) {
        return groups.stream().map(this::groupToGroupDto)
                .collect(Collectors.toList());
    }
}
