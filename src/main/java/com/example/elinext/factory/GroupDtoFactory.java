package com.example.elinext.factory;

import com.example.elinext.dto.GroupDto;
import com.example.elinext.models.Group;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GroupDtoFactory {

    UniversityDtoFactory universityDtoFactory;

    public GroupDto createGroupDto (Group group) {
        return GroupDto.builder().number(group.getGroupNumber())
                .id(group.getId())
                .universityDto(universityDtoFactory.createUniversityDto(group.getUniversity()))
                .build();
    }
}

