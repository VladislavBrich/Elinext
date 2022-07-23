package com.example.elinext.controllers;


import com.example.elinext.dto.AskDto;
import com.example.elinext.dto.UniversityDto;
import com.example.elinext.exception.BadRequestException;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.factory.UniversityDtoFactory;
import com.example.elinext.models.University;
import com.example.elinext.repositories.UniversityRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("university")
public class UniversityController {

    @Autowired
    UniversityRepo universityRepo;

    @Autowired
    UniversityDtoFactory universityDtoFactory;

    @GetMapping()
    public ResponseEntity<List<UniversityDto>> getUniversity(@RequestParam String filter) {

        boolean isFiltered = !filter.trim().isEmpty();
        List<University> universities = universityRepo.findAllByFilter(isFiltered, filter);

        return ResponseEntity.ok(universityDtoFactory.createUniversityDtoList(universities));

    }

    @PostMapping("create/{universityName}")
    public ResponseEntity<UniversityDto> createUniversity(@PathVariable String universityName) {
        if (universityRepo.existsByUniversityName(universityName)) {
            throw new BadRequestException(String.format("University with that name \"%s\" is already exist", universityName));
        }
        University university = universityRepo.saveAndFlush(University.createDefault(universityName));

        return ResponseEntity.ok(universityDtoFactory.createUniversityDto(university));
    }

    @DeleteMapping("delete/{universityId}")
    public ResponseEntity<AskDto> deleteUniversity(@PathVariable Long universityId){
        if (universityRepo.existsById(universityId)){
            universityRepo.deleteById(universityId);
        }
        return ResponseEntity.ok(AskDto.makeDefault(true));
    }
}
