package com.example.elinext.dto;

import com.example.elinext.hellpers.DaysOfWeek;
import lombok.Data;
import lombok.NonNull;
import java.time.LocalDateTime;

@Data
public class AskRequestLectureDto {
    @NonNull
    private String lectureName;

    @NonNull
    private Long groupId;

    @NonNull
    private String teacherSurname;

    @NonNull
    private DaysOfWeek daysOfWeek;

    @NonNull
    private LocalDateTime localDateTime;
}
