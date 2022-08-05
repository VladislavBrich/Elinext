package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestUniversityDto;
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
    public UniversityDto create(AskRequestUniversityDto askRequestUniversityDto) {
        if (universityRepo.existsByName(askRequestUniversityDto.getUniversityName())) {
            throw new BadRequestException(String.format("University with that name \"%s\" is already exist",
                    askRequestUniversityDto.getUniversityName())
            );
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
        University university = universityRepo.findById(universityId)
                .orElseThrow(() -> new NotFoundException(String.format("Not Found")));
        return universityMapper.universityToUniversityDto(university);
    }

    @Override
    public void delete(Long universityId) {
        if (universityRepo.existsById(universityId)) {
            universityRepo.deleteById(universityId);
        }
        throw new NotFoundException(String.format("University with id " + universityId + " is not exist"));
    }

    @Override
    public Boolean existsByName(String name) {
        if (universityRepo.existsByName(name)) {
            return true;
        } else
            throw new BadRequestException(String.format("University with that name \"%s\" is not exist", name));
    }

    public University findById(Long universityId) {
        return universityRepo.findById(universityId)
                .orElseThrow(() -> new NotFoundException(String.format("University with same id not found")));
    }

    @Override
    public University findByName(String universityName) {
        return universityRepo.findByName(universityName);
    }

    @Override
    public Boolean existsByUniversityId(Long id) {
        return universityRepo.existsById(id);
    }

    @Override
    public UniversityDto update(Long id, String name) {
        University university = findById(id);
        university.setName(name);
        universityRepo.save(university);
        return universityMapper.universityToUniversityDto(university);
    }
}

