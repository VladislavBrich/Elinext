package com.example.elinext.models;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "universiry")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name= "name")
    @NonNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id",referencedColumnName = "id")
    private List <Audience> audiences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id",referencedColumnName = "id")
    private List <Group> groups = new ArrayList<>();


    public University() {

    }
}
