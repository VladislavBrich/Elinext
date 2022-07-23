package com.example.elinext.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupDto {
    @NonNull
    Long id;

    @NonNull
    Integer number;

    @NonNull
    UniversityDto universityDto;
}
