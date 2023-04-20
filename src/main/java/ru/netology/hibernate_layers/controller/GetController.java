package ru.netology.hibernate_layers.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.event.internal.DefaultPersistOnFlushEventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.service.GetService;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class GetController {
    public final GetService getService;
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam(value = "city") String city) {
        return getService.getPersonsByCity(city);
    }
}
