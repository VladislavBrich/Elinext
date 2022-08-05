package com.example.elinext.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AskRequestTeacherDto {

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String universityName;
}
