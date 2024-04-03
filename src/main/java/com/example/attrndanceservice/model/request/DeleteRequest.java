package com.example.attrndanceservice.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeleteRequest {

    private final long userID;
    private final LocalDate date;
}
