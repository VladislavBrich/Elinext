package com.example.elinext.models;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "audience")
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Integer audienceNumber;


    @NonNull
    @OneToMany(orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "audience_id",referencedColumnName = "id")
    private List<Group> groups = new ArrayList<>();

    @NonNull
    @OneToMany(orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "audience_id",referencedColumnName = "id")
    private List<Lecture> lectures = new ArrayList<>();


    public Audience() {

    }
}
