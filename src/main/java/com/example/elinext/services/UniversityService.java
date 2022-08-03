package com.example.elinext.services;

import com.example.elinext.dto.AskRequestUniversityDto;
import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.University;

public interface UniversityService {

    UniversityDto getById(Long id);

    UniversityDto create(AskRequestUniversityDto askRequestUniversityDto);

    void delete(Long universityId);

    Boolean existsByUniversityName(String universityName);

    University findById(Long id);

    University findByName(String universityName);

    Boolean existsByUniversityId(Long id);

    UniversityDto update (Long id,String name);
}
