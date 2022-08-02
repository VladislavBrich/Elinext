package com.example.elinext.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "groups")
public class Group extends BaseEntity {
    @Column
    private Long groupNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private List<Student> students = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private List<Lecture> lectures = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    University university;

    @Column(name = "university_id", updatable = false, insertable = false)
    Long universityId;

    public Group(Long groupNumber, University university) {
        this.groupNumber = groupNumber;
        this.university = university;
    }

    public Group(Long id) {
        this.id = id;
    }
}

