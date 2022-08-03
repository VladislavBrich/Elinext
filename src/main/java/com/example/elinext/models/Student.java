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
public class Student extends BaseEntity {

    private String name;

    private String surname;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @Column(name = "group_id", updatable = false, insertable = false)
    Long groupId;


    public Student(String name, String surname, Group group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
    }
}








