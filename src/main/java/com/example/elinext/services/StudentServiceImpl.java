package com.example.elinext.services;

import com.example.elinext.models.Audience;

import com.example.elinext.models.Student;
import com.example.elinext.repositories.AudienceRepo;
import com.example.elinext.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentsService{
    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private AudienceRepo audienceRepo;


    @Override
    public List<Student> getByName(String studentName) {
        List <Student> students = studentsRepo.findAllByStudentName(studentName);
        return students;
    }

    @Override
    public List<Student> getByLastName(String studentLastName) {
        List <Student> students = studentsRepo.findAllByStudentLastName(studentLastName);
        return students;
    }

    @Override
    public List<Student> getByGroupName(int groupNumber) {
        List<Student> students = studentsRepo.findAllByGroupNumber(groupNumber);
        return students;
    }

   @Override
    public List<Audience> getTimetable(String studentName) {
        List<Audience> timeTable = audienceRepo.findAudiencesByStudentName(studentName);
        return timeTable;
    }
}
