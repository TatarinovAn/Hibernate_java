package ru.netology.hibernate_java.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
