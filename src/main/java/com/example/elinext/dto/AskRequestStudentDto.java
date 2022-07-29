package com.example.elinext.dto;

import lombok.Data;

@Data
public class AskRequestStudentDto {
    private String studentName;
    private String studentLastName;
    private Long groupId;

}
