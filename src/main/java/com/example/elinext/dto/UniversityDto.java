package com.example.elinext.dto;


import com.example.elinext.models.Group;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversityDto {

    @NonNull
    Long id;

    @NonNull
    String name;

    @NonNull
    List<Group> groups;


}

