package ru.netology.hibernate_java.controller;


import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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


    @GetMapping("/by-city")
    @Secured("ROLE_READER")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        return repostoryHibernate.findByCityOfLiving(city);
    }


    @GetMapping("/by-age")
    @RolesAllowed("ROLE_WRITER")
    public List<Person> findByPersonId_AgeLessThanOrderByPersonId_Age(@RequestParam int age) {
        return repostoryHibernate.findByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }


    @GetMapping("/by-name-and-surname")
    @PreAuthorize("hasRole('ROLE_WRITER') or hasRole('ROLE_DELETE')")
    public Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(@RequestParam String name, @RequestParam String surname) {
        return repostoryHibernate.findPersonByPersonId_NameAndPersonId_Surname(name, surname);
    }

    @GetMapping("/by-phone")
    @PreAuthorize("authentication.principal.username == 'reader'")
    public List<Person> findByPhoneNumber(@RequestParam String phone) {
        return repostoryHibernate.findByCityOfLiving(phone);
    }
}
