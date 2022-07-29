package com.example.elinext.services;

import com.example.elinext.dto.AskRequestUniversityDto;
import com.example.elinext.dto.GroupDto;
import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.Group;
import com.example.elinext.models.University;

import java.util.List;
import java.util.Set;

public interface UniversityService {

    UniversityDto getById(Long id);

    UniversityDto create(AskRequestUniversityDto askRequestUniversityDto);

    void delete(Long universityId);


    Boolean existsByUniversityName(String universityName);

    University findById (Long id);

    University findByName(String universityName);

    Boolean existsByUniversityId(Long id);


}
