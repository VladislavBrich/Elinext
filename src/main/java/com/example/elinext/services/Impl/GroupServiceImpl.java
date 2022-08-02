package com.example.elinext.services.Impl;

import com.example.elinext.dto.AskRequestGroupDto;
import com.example.elinext.dto.GroupDto;
import com.example.elinext.dto.LectureDto;
import com.example.elinext.dto.StudentDto;
import com.example.elinext.exception.BadRequestException;
import com.example.elinext.exception.NotFoundException;
import com.example.elinext.mapper.GroupMapper;
import com.example.elinext.mapper.LectureMapper;
import com.example.elinext.mapper.StudentMapper;
import com.example.elinext.models.Group;
import com.example.elinext.models.Lecture;
import com.example.elinext.models.Student;
import com.example.elinext.models.University;
import com.example.elinext.repositories.GroupsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements com.example.elinext.services.GroupService {

    private GroupsRepo groupsRepo;
    private UniversityServiceImpl universityService;
    private GroupMapper groupMapper;
    private StudentMapper studentMapper;

    private LectureMapper lectureMapper;


    @Override
    public GroupDto create(AskRequestGroupDto askRequestGroupDto) {
        if (!universityService.existsByUniversityName(askRequestGroupDto.getUniversityName())) {
            throw new BadRequestException(String.format("University with that name \"%s\" is not exist", askRequestGroupDto.getUniversityName()));
        }
        University university = universityService.findByName(askRequestGroupDto.getUniversityName());
        Group group = new Group(askRequestGroupDto.getGroupNumber(), university);
        groupsRepo.save(group);
        return groupMapper.groupToGroupDto(group);
    }

    public List<GroupDto> getAll(Long universityId) {
        University university = universityService.findById(universityId);
        List<Group> groups = university.getGroups();
        return groupMapper.groupDtoList(groups);
    }

    @Override
    public Group getById(Long id) {
        return groupsRepo.findById(id).orElseThrow(() -> new NotFoundException(String.format("Not Found")));
    }

    @Override
    public List<StudentDto> getAllStudentByGroupId(Long groupId) {
        Group group = getById(groupId);
        List<Student> students = group.getStudents();
        return studentMapper.createStudentDtoList(students);
    }

    @Override
    public boolean existByGroupId(Long groupId) {
        return groupsRepo.existsById(groupId);
    }

    @Override
    public List<LectureDto> getAllLecturesByGroupId(Long groupId) {
        Group group = getById(groupId);
        List<Lecture> lectures = group.getLectures();
        return lectureMapper.createListLectureDto(lectures);
    }

    public void delete(Long groupNumber, Long universityId) {
        if (universityService.existsByUniversityId(universityId)
                && groupsRepo.existsByGroupNumber(groupNumber)) {
            groupsRepo.deleteByGroupNumberAndUniversityId(groupNumber, universityId);
        } else throw new NotFoundException(
                String.format("Group with groupNumber " + groupNumber + " or universityId "
                        + universityId + " is not exist")
        );
    }
}


