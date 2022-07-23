package com.example.elinext.services;

import com.example.elinext.models.Group;
import com.example.elinext.models.Student;
import com.example.elinext.models.University;

import java.util.List;

public interface GroupService {


    Group create(Integer groupNumber, University university);


}
