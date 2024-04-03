package com.example.attrndanceservice.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Info {

    public static final int FIRST_LESSON = 1;
    public static final int LESSONS_ON_DAY = 7;

    @EmbeddedId
    private InfoID infoID;
    private String className;
    private int startLesson;
    private int endLesson;
    private String reason;

    @Override
    public String toString() {
        return infoID.getUserID() + " " + className + " " + " " + infoID.getDay() + " " + startLesson + "-" + endLesson + " " + reason;
    }

    public Info(long userID, String className, LocalDate day, int startLesson, int endLesson, String reason) {
        this.infoID = new InfoID(userID, day);
        this.className = className;
        this.startLesson = startLesson;
        this.endLesson = endLesson;
        this.reason = reason;
    }
}
