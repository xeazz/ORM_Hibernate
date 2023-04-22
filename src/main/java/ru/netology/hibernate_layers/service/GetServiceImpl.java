package ru.netology.hibernate_layers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.exception.IncorrectInputDataException;
import ru.netology.hibernate_layers.repository.GetRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetServiceImpl implements GetService {
    private final GetRepository getRepository;

    @Override
    public List<Person> getPersonsByCity(String city) {
        List<Person> personList = getRepository.findPersonByCity(city);
        if (personList.isEmpty()) {
            throw new IncorrectInputDataException("Пользователей с таким городом не найдено");
        }
        return personList;
    }

    @Override
    public List<Person> getPersonsByAge(int age) {
        List<Person> personList = getRepository.findPersonByPersonFirstKeyAgeLessThanOrderByPersonFirstKeyAge(age);
        if (personList.isEmpty()) {
            throw new IncorrectInputDataException("Пользователей с таким возрастом не найдено");
        }
        return personList;
    }

    @Override
    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        Optional<Person> person = getRepository.findPersonByPersonFirstKeyNameAndPersonFirstKeySurname(name, surname);
        if (person.isEmpty()) {
            throw new IncorrectInputDataException("Пользователь с таким именем и фамилией не найдены!");
        }
        return person;
    }

    @Override
    public Person create(Person person) {
        return getRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        Optional<Person> optionalPerson = getRepository.findPersonByPersonFirstKey(person.getPersonFirstKey());
        if (optionalPerson.isEmpty()) {
            throw new IncorrectInputDataException("Пользователь не найден:( Изменять нечего...");
        }
        optionalPerson.get().setCity(person.getCity());
        optionalPerson.get().setCity(person.getCity());
        return getRepository.save(person);
    }

    @Override
    public String delete(Person person) {
        Optional<Person> optionalPerson = getRepository.findPersonByPersonFirstKey(person.getPersonFirstKey());
        if (optionalPerson.isEmpty()) {
            throw new IncorrectInputDataException("Пользователь не найден:( Нельзя удалить...");
        }
        getRepository.delete(person);
        return "Пользователь " + person.getPersonFirstKey() + " удален!";
    }
}
