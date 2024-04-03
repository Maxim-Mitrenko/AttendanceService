package com.example.attrndanceservice.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeriodRequest {

    private final long userID;
    private final String className;
    private final LocalDate start;
    private final LocalDate end;
    private final String reason;
}
