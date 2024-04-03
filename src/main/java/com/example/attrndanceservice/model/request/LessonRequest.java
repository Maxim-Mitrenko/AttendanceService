package com.example.attrndanceservice.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LessonRequest {

    private final long userID;
    private final String className;
    private final int start;
    private final int end;
    private final LocalDate date;
    private final String reason;
}
