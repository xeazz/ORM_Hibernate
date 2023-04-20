package ru.netology.hibernate_layers.service;

import ru.netology.hibernate_layers.Entity.Person;

import java.util.List;

public interface GetService {
    List<Person> getPersonsByCity (String city);
}
