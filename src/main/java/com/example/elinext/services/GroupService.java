package com.example.elinext.services;

import com.example.elinext.models.Group;
import com.example.elinext.models.Student;

import java.util.List;

public interface GroupService {



    List <Student> getAllStudents(Long groupId);

    List <Group> getAll();




}
