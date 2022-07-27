package com.example.elinext.controllers;


import com.example.elinext.dto.AskDto;
import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.University;
import com.example.elinext.services.Impl.UniversityServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
    public UniversityDto getUniversityById (@PathVariable Long id){
        return universityService.getById(id);
    }

    @PostMapping("/create/{universityName}")
    public AskDto createUniversity(@PathVariable String universityName) {
        universityService.create(universityName);
        return AskDto.makeDefault(true);
    }
    @DeleteMapping("/delete/{universityId}")
    public AskDto deleteUniversity(@PathVariable Long universityId) {
       universityService.delete(universityId);
        return AskDto.makeDefault(true);
    }
}
