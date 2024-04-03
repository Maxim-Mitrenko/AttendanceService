package com.example.attrndanceservice.controller;

import com.example.attrndanceservice.model.request.DayRequest;
import com.example.attrndanceservice.model.request.DeleteRequest;
import com.example.attrndanceservice.model.request.LessonRequest;
import com.example.attrndanceservice.model.request.PeriodRequest;
import com.example.attrndanceservice.service.InfoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfoController {

    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @PostMapping("/lesson")
    public String lesson(@RequestBody LessonRequest request) {
        service.lesson(request.getUserID(), request.getClassName(), request.getStart(), request.getEnd(), request.getDate(), request.getReason());
        return byUser(request.getUserID());
    }

    @PostMapping("/day")
    public String day(@RequestBody DayRequest request) {
        service.day(request.getUserID(), request.getClassName(), request.getDate(), request.getReason());
        return byUser(request.getUserID());
    }

    @PostMapping("/period")
    public String period(@RequestBody PeriodRequest request) {
        service.period(request.getUserID(), request.getClassName(), request.getStart(), request.getEnd(), request.getReason());
        return byUser(request.getUserID());
    }

    @GetMapping("/all")
    public String all() {
        return service.all();
    }

    @GetMapping("/byUser")
    public String byUser(@RequestParam long userID) {
        return service.byUser(userID);
    }

    @GetMapping("/byClass")
    public String byClass(@RequestParam String className) {
        return service.byClass(className);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteRequest request) {
        service.delete(request.getUserID(), request.getDate());
    }
}
