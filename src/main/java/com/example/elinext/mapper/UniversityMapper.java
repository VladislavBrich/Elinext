package com.example.elinext.mapper;

import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class UniversityMapper {

    public UniversityDto universityToUniversityDto (University university){
       return new UniversityDto(university.getId(), university.getUniversityName(), university.getGroups());
    }
    public List<UniversityDto> universityDtoList (List<University>universities){
        return universities.stream().map(this::universityToUniversityDto)
                .collect(Collectors.toList());
    }

}
