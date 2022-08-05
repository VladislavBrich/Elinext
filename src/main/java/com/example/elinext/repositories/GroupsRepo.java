package com.example.elinext.repositories;

import com.example.elinext.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GroupsRepo extends JpaRepository<Group, Long> {

    void deleteByNumberAndUniversityId(Long number, Long universityId);

    boolean existsByNumber(Long number);
}
