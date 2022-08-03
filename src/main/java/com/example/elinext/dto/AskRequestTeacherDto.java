package com.example.elinext.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class AskRequestTeacherDto {

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String universityName;
}
