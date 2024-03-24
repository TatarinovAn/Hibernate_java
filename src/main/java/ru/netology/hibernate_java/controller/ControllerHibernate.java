package ru.netology.hibernate_java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate_java.entity.Person;
import ru.netology.hibernate_java.repository.RepostoryHibernate;

import java.util.List;

@RestController
public class ControllerHibernate {
    private final RepostoryHibernate repostoryHibernate;

    public ControllerHibernate(RepostoryHibernate repostoryHibernate) {
        this.repostoryHibernate = repostoryHibernate;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPeople(@RequestParam String city) {
        return repostoryHibernate.getPeople(city);
    }
}
