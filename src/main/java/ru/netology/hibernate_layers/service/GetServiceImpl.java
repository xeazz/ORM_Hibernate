package ru.netology.hibernate_layers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.repository.GetRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetServiceImpl implements GetService{
    private final GetRepository getRepository;
    @Override
    public List<Person> getPersonsByCity(String city) {
        return getRepository.getPersonsByCity(city);
    }
}
