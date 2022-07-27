package com.example.elinext.services.Impl;

import com.example.elinext.dto.UniversityDto;
import com.example.elinext.exception.BadRequestException;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.mapper.UniversityMapper;
import com.example.elinext.models.University;
import com.example.elinext.repositories.UniversityRepo;
import com.example.elinext.services.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private UniversityRepo universityRepo;
    private UniversityMapper universityMapper;

    @Override
    public void create(String universityName) {
        if (universityRepo.existsByUniversityName(universityName)) {
            throw new BadRequestException(String.format("University with that name \"%s\" is already exist", universityName));
        }
        University university = new University(universityName);
        universityRepo.save(university);
    }

    public List<UniversityDto> getAll() {
        List<University> universities = universityRepo.findAll();
        return universityMapper.universityDtoList(universities);
    }

    public UniversityDto getById(Long universityId) {
        University university = universityRepo.findById(universityId).orElseThrow(() -> new NotFoundException(String.format("Not Found")));
         return universityMapper.universityToUniversityDto(university);
    }


    @Override
    public void delete(Long universityId) {
        if (universityRepo.existsById(universityId)) {
            universityRepo.deleteById(universityId);
        }
    }

    @Override
    public Boolean existsByUniversityName(String universityName) {
        return  universityRepo.existsByUniversityName(universityName);
    }

}
