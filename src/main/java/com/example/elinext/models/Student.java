package com.example.elinext.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student extends BaseEntity {

    private String studentName;

    private String studentLastName;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @Column(name = "group_id", updatable = false, insertable = false)
    Long groupId;

//    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    private List<Lecture> lectures = new ArrayList<>();

    public Student(String studentName, String studentLastName, Group group) {
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.group = group;
    }
}








