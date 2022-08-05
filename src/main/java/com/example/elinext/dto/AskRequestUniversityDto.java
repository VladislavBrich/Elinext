package com.example.elinext.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AskRequestUniversityDto {

    @NonNull
    private String name;
}
