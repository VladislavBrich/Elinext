package com.example.elinext.services;

import com.example.elinext.models.Audience;

import com.example.elinext.models.Group;
import com.example.elinext.models.Lecture;
import com.example.elinext.models.Student;
import com.example.elinext.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StudentsService {


    List<Student> getAllByLastName(String studentLastName);



}
