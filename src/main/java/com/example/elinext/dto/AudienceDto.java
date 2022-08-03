package com.example.elinext.dto;

import lombok.Data;

@Data
public class AudienceDto {

    private Long id;
    private Long number;

    private UniversityDto university;

    public AudienceDto(Long id, Long number, UniversityDto university) {
        this.id = id;
        this.number = number;
        this.university = university;
    }
}
