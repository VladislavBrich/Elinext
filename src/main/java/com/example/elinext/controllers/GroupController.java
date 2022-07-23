package com.example.elinext.controllers;

import com.example.elinext.dto.GroupDto;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.factory.GroupDtoFactory;
import com.example.elinext.models.Group;
import com.example.elinext.models.University;
import com.example.elinext.repositories.UniversityRepo;
import com.example.elinext.services.Impl.GroupServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/university/groups")
public class GroupController {
    @Autowired
    GroupServiceImpl groupService;

    @Autowired
    GroupDtoFactory groupDtoFactory;

    @Autowired
    UniversityRepo universityRepo;

    @GetMapping()
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        return ResponseEntity.ok(null);
    }

    @PostMapping("create/{universityId}/{groupNumber}")
    public ResponseEntity<GroupDto> createGroup(@PathVariable Integer groupNumber, @PathVariable Long universityId) {

        University university = universityRepo.findById(universityId)
                .orElseThrow(() -> new NotFoundException(String.format("Not Found")));
        Group group = groupService.create(groupNumber, university);

        return ResponseEntity.ok(groupDtoFactory.createGroupDto(group));

    }
}
