package com.example.elinext.repositories;

import com.example.elinext.models.Group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepo extends JpaRepository<Group, Long> {


}
