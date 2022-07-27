package com.example.elinext.dto;

import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class GroupDto {

    private Long id;

    private Long number;

    UniversityDto universityDto;

    public GroupDto(Long id, Long number) {
        this.id = id;
        this.number = number;
    }

}

