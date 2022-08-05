package com.example.elinext.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AskRequestStudentDto {
    private String name;
    private String surname;
    private Long groupId;

}
