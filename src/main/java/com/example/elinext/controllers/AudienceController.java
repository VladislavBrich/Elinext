package com.example.elinext.controllers;

import com.example.elinext.dto.AskRequestAudienceDto;
import com.example.elinext.dto.AudienceDto;
import com.example.elinext.services.Impl.AudienceServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "audience", produces = MediaType.APPLICATION_JSON_VALUE)
public class AudienceController {

    private AudienceServiceImpl audienceService;

    @PostMapping("create")
    public AudienceDto create(@RequestBody AskRequestAudienceDto askRequestAudienceDto) {
        return audienceService.create(askRequestAudienceDto);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody AskRequestAudienceDto askRequestAudienceDto) {
        return audienceService.delete(askRequestAudienceDto.getNumber(), askRequestAudienceDto.getUniversityId());
    }

    @GetMapping("{universityId}")
    public List<AudienceDto> getAllByUniversity(@PathVariable Long universityId) {
        return audienceService.getAllByUniversityId(universityId);
    }
    @Transactional
    @PostMapping("update/{id}")
    public AudienceDto update (@PathVariable Long id,@RequestParam (name = "number")Long number){
       return audienceService.update(id,number);
    }
}
