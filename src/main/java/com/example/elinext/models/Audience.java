package com.example.elinext.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "audience")
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "audience_number")
    private String audienceName;

    private int groupNumber;

    private String timeClasses;

    private String dayForClasses;
}
