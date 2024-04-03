package com.example.attrndanceservice.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DayRequest {

    private final long userID;
    private final String className;
    private final LocalDate date;
    private final String reason;
}
