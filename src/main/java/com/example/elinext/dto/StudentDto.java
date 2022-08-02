package com.example.elinext.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {

    private Long id;

    private String StudentName;

    private String studentLastName;

    private GroupDto group;
}

