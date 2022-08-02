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
    private String lecturesName;
    @Column(name = "date_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime localDateTime;
    @Enumerated(EnumType.STRING)
    DaysOfWeek daysOfWeek;

    @ManyToOne
    @JoinColumn(name = "teacher_surname", referencedColumnName = "teacherSurname")
    private Teacher teacher;

    @Column(name = "teacher_surname", updatable = false, insertable = false)
    String teacherSurname;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @Column(name = "group_id", updatable = false, insertable = false)
    Long groupId;

    public Lecture(String lecturesName, LocalDateTime localDateTime, DaysOfWeek daysOfWeek, Teacher teacher, Group group) {

        this.lecturesName = lecturesName;
        this.localDateTime = localDateTime;
        this.daysOfWeek = daysOfWeek;
        this.teacher = teacher;
        this.group = group;
    }
}



