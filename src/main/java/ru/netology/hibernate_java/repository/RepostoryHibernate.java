package ru.netology.hibernate_java.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_java.entity.Person;

import java.util.List;

@Repository
@AllArgsConstructor
public class RepostoryHibernate {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPeople(String city) {
        var nativeQuery = entityManager.createNativeQuery("select * from persons where city_of_living = :city order by city_of_living", Person.class);
        nativeQuery.setParameter("city", city);
        return nativeQuery.getResultList();
    }
}
