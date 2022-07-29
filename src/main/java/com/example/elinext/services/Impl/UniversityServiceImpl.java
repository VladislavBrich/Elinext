package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestUniversityDto;
import com.example.elinext.dto.GroupDto;
import com.example.elinext.dto.UniversityDto;
import com.example.elinext.exception.BadRequestException;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.mapper.GroupMapper;
import com.example.elinext.mapper.UniversityMapper;
import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import com.example.elinext.repositories.UniversityRepo;
import com.example.elinext.services.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private UniversityRepo universityRepo;
    private UniversityMapper universityMapper;

    private GroupMapper groupMapper;

    @Override
    public UniversityDto create(AskRequestUniversityDto askRequestUniversityDto) {
        if (universityRepo.existsByUniversityName(askRequestUniversityDto.getUniversityName())) {
            throw new BadRequestException(String.format("University with that name \"%s\" is already exist", askRequestUniversityDto.getUniversityName()));
        }
        University university = new University(askRequestUniversityDto.getUniversityName());
        universityRepo.save(university);
        return universityMapper.universityToUniversityDto(university);
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
        throw new NotFoundException(String.format("Школы с такими id не существует"));
    }

    @Override
    public Boolean existsByUniversityName(String universityName) {
        return universityRepo.existsByUniversityName(universityName);
    }

    public University findById(Long universityId) {
        return universityRepo.findById(universityId)
                .orElseThrow(() -> new NotFoundException(String.format("University with same id not found")));
    }

    @Override
    public University findByName(String universityName) {
        return universityRepo.findByUniversityName(universityName);
    }

    @Override
    public Boolean existsByUniversityId(Long id) {
        return universityRepo.existsById(id);
    }


     }

