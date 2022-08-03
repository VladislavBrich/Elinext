package com.example.elinext.mapper;

import com.example.elinext.dto.AudienceDto;
import com.example.elinext.models.Audience;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AudienceMapper {
    private UniversityMapper universityMapper;

   public AudienceDto createAudienceDto(Audience audience) {
        return new AudienceDto(audience.getId(), audience.getNumber(),
                universityMapper.universityToUniversityDto(audience.getUniversity())
        );
    }

    public List<AudienceDto> createListAudienceDto(List<Audience> audiences){
       return audiences.stream().map(this::createAudienceDto).collect(Collectors.toList());
    }
}
