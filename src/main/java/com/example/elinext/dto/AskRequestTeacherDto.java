package com.example.elinext.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class AskRequestTeacherDto {

    @NonNull
    private String teacherName;

    @NonNull
    private String teacherSurname;

    @NonNull
    private String universityName;
}
