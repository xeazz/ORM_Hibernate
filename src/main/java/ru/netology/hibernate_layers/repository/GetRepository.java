package ru.netology.hibernate_layers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.Entity.PersonFirstKey;

import java.util.List;
import java.util.Optional;

public interface GetRepository extends JpaRepository<Person, PersonFirstKey> {
    List<Person> findPersonByCity (String city);
    List<Person> findPersonByPersonFirstKeyAgeLessThanOrderByPersonFirstKeyAge (int age);
    Optional<Person> findPersonByPersonFirstKeyNameAndPersonFirstKeySurname (String name, String surname);
    Optional<Person> findPersonByPersonFirstKey(PersonFirstKey personFirstKey);
//    Optional<Person> findPersonByPersonFirstKeyNameAndPersonFirstKeySurnameAndPersonFirstKeyAge (String name, String surname, int age);
}
