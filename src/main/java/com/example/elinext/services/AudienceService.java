package com.example.elinext.services;

import com.example.elinext.dto.AskRequestAudienceDto;
import com.example.elinext.dto.AudienceDto;

import java.util.List;

public interface AudienceService {

    AudienceDto create(AskRequestAudienceDto askRequestAudienceDto);

    String delete(Long number, Long universityId);

    List <AudienceDto> getAllByUniversityId (Long id);

    AudienceDto update (Long id, Long number);
}
