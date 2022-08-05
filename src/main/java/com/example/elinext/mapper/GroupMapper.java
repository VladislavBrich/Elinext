package com.example.elinext.mapper;

import com.example.elinext.dto.GroupDto;
import com.example.elinext.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GroupMapper {

    private final UniversityMapper universityMapper;

    public GroupDto groupDtoForLecture (Group group){
        return new GroupDto(group.getId(),group.getNumber());
    }

    public GroupDto groupToGroupDto(Group group) {
        return new GroupDto(group.getId(),
                group.getNumber(),
                universityMapper.universityToUniversityDto(group.getUniversity()));
    }

    public List<GroupDto> groupDtoList(List<Group> groups) {
        return groups.stream().map(this::groupToGroupDto)
                .collect(Collectors.toList());
    }
}
