package ru.netology.hibernate_layers.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.service.GetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class GetController {
    public final GetService getService;
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam(value = "city") String city) {
        return getService.getPersonsByCity(city);
    }
    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam(value = "age") int age) {
        return getService.getPersonsByAge(age);
    }
    @GetMapping("/by-name-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) {
        return getService.getPersonsByNameAndSurname(name, surname);
    }

    @PostMapping("/create")
    public Person create (@RequestBody Person person){
        return getService.create(person);
    }

    @PutMapping("/update")
    public Person update (@RequestBody Person person){
        return getService.update(person);
    }
    @DeleteMapping("/delete")
    public String delete (@RequestBody Person person){
       return getService.delete(person);
    }
}
