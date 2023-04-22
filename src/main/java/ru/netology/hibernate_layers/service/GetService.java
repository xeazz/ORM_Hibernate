package ru.netology.hibernate_layers.service;

import ru.netology.hibernate_layers.Entity.Person;

import java.util.List;
import java.util.Optional;

public interface GetService {
    List<Person> getPersonsByCity (String city);
    List<Person> getPersonsByAge (int age);
    Optional<Person> getPersonsByNameAndSurname (String name, String surname);
    Person update (Person person);
    Person create (Person person);
    String delete (Person person);
}
