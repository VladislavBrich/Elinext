package com.example.elinext.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Builder
@Entity
@Data
@Table(name = "groups")
@ToString
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private Integer groupNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private List<Student> students = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private List<Lecture> lectures = new ArrayList<>();

    @NonNull
    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private University university;


    public Group() {
    }

    public static Group makeDefault (Integer GroupNumber, University university){
        return builder()
                .groupNumber(builder().groupNumber)
                .university(university)
                .build();
    }
}
