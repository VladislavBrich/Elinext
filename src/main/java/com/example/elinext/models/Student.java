package com.example.elinext.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String studentName;

    @NonNull
    private String studentLastName;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "lecture_id",referencedColumnName = "id")
    private Lecture lecture;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private Group group;

    public Student() {

    }
}


