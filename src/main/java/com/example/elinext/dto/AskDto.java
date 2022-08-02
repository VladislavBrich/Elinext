package com.example.elinext.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AskDto {

    Boolean answer;

    public static AskDto giveAnAnswer(Boolean answer) {
        return builder().answer(answer).build();
    }
}
