package com.example.elinext.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String studentName;


    private String studentLastName;



    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @Column(name = "group_id", updatable = false, insertable = false)
    Long groupId;

    public Student(String studentName, String studentLastName, Group group) {
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.group = group;
    }
}








