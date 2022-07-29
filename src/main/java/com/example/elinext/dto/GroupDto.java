package com.example.elinext.dto;

import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GroupDto {
    private Long id;
    private Long number;

    private UniversityDto university;


    public GroupDto(Long id, Long number, UniversityDto university) {
        this.id = id;
        this.number = number;
        this.university = university;
    }
}



