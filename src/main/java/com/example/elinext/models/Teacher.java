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
    private String teacherName;

    @Column
    private String teacherSurname;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private List<Lecture> lectures = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    University university;

    @Column(name = "university_id", updatable = false, insertable = false)
    Long universityId;

    public Teacher(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public Teacher(String teacherName, String teacherSurname, University university) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.university = university;
    }
}
