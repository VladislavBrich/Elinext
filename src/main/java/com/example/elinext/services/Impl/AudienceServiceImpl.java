package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestAudienceDto;
import com.example.elinext.dto.AudienceDto;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.mapper.AudienceMapper;
import com.example.elinext.models.Audience;
import com.example.elinext.models.University;
import com.example.elinext.repositories.AudienceRepo;
import com.example.elinext.services.AudienceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AudienceServiceImpl implements AudienceService {

    private UniversityServiceImpl universityService;

    private AudienceMapper audienceMapper;

    private AudienceRepo audienceRepo;

    @Override
    public AudienceDto create(AskRequestAudienceDto askRequestAudienceDto) {
        University university = universityService.findById(askRequestAudienceDto.getUniversityId());
        Audience audience = new Audience(askRequestAudienceDto.getNumber(), university);
        audienceRepo.save(audience);
        return audienceMapper.createAudienceDto(audience);
    }

    @Override
    public String delete(Long number, Long universityId) {
        if (universityService.existsByUniversityId(universityId)
                && audienceRepo.existsByNumber(number)) {
            audienceRepo.deleteByNumberAndUniversityId(number, universityId);
            return "Audience with number " + number + " deleted";
        } else throw new NotFoundException(
                String.format("Group with number " + number + " or universityId "
                        + universityId + " is not exist"));
    }

    @Override
    public List<AudienceDto> getAllByUniversityId(Long id) {
        University university = universityService.findById(id);
        List<Audience> audiences = university.getAudiences();
        return audienceMapper.createListAudienceDto(audiences);
    }

    @Override
    public AudienceDto update(Long id, Long number) {
        Audience audience = audienceRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Audience with id " + id + " not exist"))
                );
        audience.setNumber(number);
        audienceRepo.save(audience);
        return audienceMapper.createAudienceDto(audience);
    }
}
