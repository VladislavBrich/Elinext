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
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private List<Lecture> lectures = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    University university;

    @Column(name = "university_id", updatable = false, insertable = false)
    Long universityId;

    public Teacher(String surname) {
        this.surname = surname;
    }

    public Teacher(String teacherName, String surname, University university) {
        this.name = teacherName;
        this.surname = surname;
        this.university = university;
    }
}
