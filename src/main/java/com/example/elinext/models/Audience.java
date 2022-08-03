package com.example.elinext.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "audience")
public class Audience extends BaseEntity {

    @NonNull
    private Long number;

    @NonNull
    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "audience_id", referencedColumnName = "id")
    private List<Lecture> lectures = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    University university;

    @Column(name = "university_id", updatable = false, insertable = false)
    Long universityId;

    public Audience(@NonNull Long number, University university) {
        this.number = number;
        this.university = university;
    }
}


