package ru.netology.hibernate_layers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.Entity.PersonFirstKey;

import java.util.List;
import java.util.Optional;

public interface GetRepository extends JpaRepository<Person, PersonFirstKey> {
    @Query("SELECT p FROM Person p WHERE p.city = :city")
    List<Person> findPersonByCityJPQL(String city);

    @Query("SELECT p FROM Person p WHERE p.personFirstKey.age < :age ORDER BY p.personFirstKey.age")
    List<Person> findPersonByPersonFirstKeyAgeLessThanOrderByPersonFirstKeyAgeJPQL(int age);

    @Query("SELECT p FROM Person p WHERE p.personFirstKey.name = :name AND p.personFirstKey.surname = :surname")
    Optional<Person> findPersonByPersonFirstKeyNameAndPersonFirstKeySurnameJPQL(String name, String surname);

    @Query("SELECT p FROM Person p WHERE p.personFirstKey = :personFirstKey")
    Optional<Person> findPersonByPersonFirstKeyJPQL(PersonFirstKey personFirstKey);
}
