package com.example.elinext.repositories;

import com.example.elinext.models.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;
@Repository

public interface GroupsRepo extends JpaRepository<Group, Long> {

void  deleteByGroupNumberAndUniversityId(Long groupNumber, Long universityId);

boolean existsByGroupNumber(Long groupNumber);
}
