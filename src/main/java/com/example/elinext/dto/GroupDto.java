package com.example.elinext.dto;

import lombok.Data;

@Data
public class GroupDto {
    private Long id;
    private Long number;

    private UniversityDto university;

    public GroupDto(Long id, Long number) {
        this.id = id;
        this.number = number;
    }

    public GroupDto(Long id, Long number, UniversityDto university) {
        this.id = id;
        this.number = number;
        this.university = university;
    }
}



