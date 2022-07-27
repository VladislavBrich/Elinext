package com.example.elinext.services;

import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.University;

import java.util.List;
import java.util.Set;

public interface UniversityService {

    UniversityDto getById(Long id);

    void create(String universityName);

    void delete(Long universityId);


    Boolean existsByUniversityName(String universityName);
}
