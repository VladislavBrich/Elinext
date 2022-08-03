package com.example.elinext.controllers;


import com.example.elinext.dto.AskDto;
import com.example.elinext.dto.AskRequestUniversityDto;
import com.example.elinext.dto.UniversityDto;
import com.example.elinext.services.Impl.UniversityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("university")
public class UniversityController {
    private final UniversityServiceImpl universityService;

    @GetMapping()
    public List<UniversityDto> getAllUniversity() {
        return universityService.getAll();
    }

    @GetMapping("/{id}")
    public UniversityDto getUniversityById(@PathVariable Long id) {
        return universityService.getById(id);
    }

    @PostMapping("/create")
    public UniversityDto createUniversity(@RequestBody AskRequestUniversityDto askRequestUniversityDto) {
        return universityService.create(askRequestUniversityDto);
    }

    @DeleteMapping("/delete/{universityId}")
    public AskDto deleteUniversity(@PathVariable Long universityId) {
        universityService.delete(universityId);
        return AskDto.giveAnAnswer(true);
    }

    @PostMapping("update/{id}")
    public UniversityDto updateUniversity(@PathVariable Long id, @RequestParam(name = "name") String name) {
        return universityService.update(id, name);
    }
}
