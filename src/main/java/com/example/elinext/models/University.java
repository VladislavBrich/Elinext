package com.example.elinext.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "universiry")
public class University extends BaseEntity {

    @Column(name = "name")
    private String universityName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "university_id", referencedColumnName = "id")
    private List<Audience> audiences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    private List<Group> groups = new ArrayList<>();

    public University(String universityName) {
        this.universityName = universityName;
    }
}

