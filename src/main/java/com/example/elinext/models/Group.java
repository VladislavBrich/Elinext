package com.example.elinext.models;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String groupName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private List<Student> students = new ArrayList<>();

    @NonNull
    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private University university;


    public Group() {

    }
}
