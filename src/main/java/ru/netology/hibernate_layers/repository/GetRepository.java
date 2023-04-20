package ru.netology.hibernate_layers.repository;

import ru.netology.hibernate_layers.Entity.Person;

import java.util.List;

public interface GetRepository {
    List<Person> getPersonsByCity (String city);
}
