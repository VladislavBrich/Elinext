package com.example.elinext.models;

import com.example.elinext.hellpers.DaysOfWeek;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "lectures")
public class Lecture extends BaseEntity {

    @Column
    private String name;
    @Column(name = "date_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime localDateTime;
    @Enumerated(EnumType.STRING)
    DaysOfWeek daysOfWeek;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @Column(name = "teacher_id", updatable = false, insertable = false)
    Long teacherId;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @Column(name = "group_id", updatable = false, insertable = false)
    Long groupId;

    public Lecture(String name, LocalDateTime localDateTime, DaysOfWeek daysOfWeek, Teacher teacher, Group group) {

        this.name = name;
        this.localDateTime = localDateTime;
        this.daysOfWeek = daysOfWeek;
        this.teacher = teacher;
        this.group = group;
    }
}



