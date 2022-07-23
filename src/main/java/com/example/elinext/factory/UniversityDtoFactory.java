package com.example.elinext.factory;

import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.University;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UniversityDtoFactory {
    public UniversityDto createUniversityDto (University university){
        return UniversityDto.builder().id(university.getId())
                .name(university.getUniversityName()).build();
    }
    public List<UniversityDto> createUniversityDtoList (List<University>universities){
        return universities.stream()
                .map(this::createUniversityDto)
                .collect(Collectors.toList());

    }
}
