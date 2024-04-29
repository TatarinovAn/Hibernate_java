package ru.netology.hibernate_java.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate_java.entity.Person;
import ru.netology.hibernate_java.repository.RepostoryHibernate;


import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class ControllerHibernate {

    @Autowired
    private RepostoryHibernate repostoryHibernate;


    @GetMapping("/all/by-city")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        return repostoryHibernate.findByCityOfLiving(city);
    }


    @GetMapping("/admin/by-age")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Person> findByPersonId_AgeLessThanOrderByPersonId_Age(@RequestParam int age) {
        return repostoryHibernate.findByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }


    @GetMapping("/user/by-name-and-surname")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(@RequestParam String name, @RequestParam String surname) {
        return repostoryHibernate.findPersonByPersonId_NameAndPersonId_Surname(name, surname);
    }
}
