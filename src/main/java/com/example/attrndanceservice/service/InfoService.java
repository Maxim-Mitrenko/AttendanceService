package com.example.attrndanceservice.service;

import com.example.attrndanceservice.model.Info;
import com.example.attrndanceservice.model.InfoID;
import com.example.attrndanceservice.repository.InfoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class InfoService {

    private final InfoRepository repository;

    public InfoService(InfoRepository repository) {
        this.repository = repository;
    }

    public void lesson(long userID, String className, int start,
                       int end, LocalDate date, String reason) {
        var info = new Info(userID, className, date, start, end, reason);
        repository.save(info);
    }

    public void day(long userID, String className, LocalDate date, String reason) {
        var info = new Info(userID, className, date, Info.FIRST_LESSON, Info.LESSONS_ON_DAY, reason);
        repository.save(info);
    }

    public void period(long userID, String className, LocalDate start, LocalDate end, String reason) {
        if (start.isAfter(end)) throw new IllegalArgumentException("Неверный период");
        var day = start;
        while (!day.equals(end.plusDays(1))) {
            day(userID, className, day, reason);
            day = day.plusDays(1);
        }
    }

    public String all() {
        return repository.findAll().stream().map(Info::toString).collect(Collectors.joining("<br />\n"));
    }

    public String byUser(long userID) {
        return repository.findAllByInfoIDUserID(userID).stream().map(Info::toString).collect(Collectors.joining("<br />\n"));
    }

    public String byClass(String className) {
        return repository.findAllByClassName(className).stream().map(Info::toString).collect(Collectors.joining("<br />\n"));
    }

    public void delete(long userID, LocalDate date) {
        repository.delete(repository.getReferenceById(new InfoID(userID, date)));
    }
}
