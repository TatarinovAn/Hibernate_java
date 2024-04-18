package ru.netology.hibernate_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_java.entity.Person;

import java.util.List;
import java.util.Optional;


@Repository
public interface RepostoryHibernate extends JpaRepository<Person, Integer> {

    List<Person> findByCityOfLiving(String city);
    Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(String name, String surname);
    List<Person> findByPersonId_AgeLessThanOrderByPersonId_Age(int age);


}
