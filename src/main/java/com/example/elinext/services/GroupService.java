package com.example.elinext.services;

import com.example.elinext.models.Group;
import com.example.elinext.models.Student;

import java.util.List;

public interface GroupService {

    List<Group> getTimetable ();

    int getCountStudents (int countStudents);




}
