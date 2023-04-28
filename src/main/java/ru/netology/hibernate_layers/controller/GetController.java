package ru.netology.hibernate_layers.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.service.GetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@EnableWebSecurity
public class GetController {
    public final GetService getService;
    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam(value = "city") String city) {
        return getService.getPersonsByCity(city);
    }
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam(value = "age") int age) {
        return getService.getPersonsByAge(age);
    }
    @PreAuthorize("hasAnyAuthority('READ','WRITE')")
    @GetMapping("/persons/by-name-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) {
        return getService.getPersonsByNameAndSurname(name, surname);
    }

    @RolesAllowed({"ROLE_WRITE"})
    @PostMapping("/persons/create")
    public Person create (@RequestBody Person person){
        return getService.create(person);
    }

    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @DeleteMapping("/persons/delete")
    public String delete (@RequestBody Person person){
       return getService.delete(person);
    }
    @GetMapping("/persons/lk")
    @PreAuthorize("#username == authentication.principal.username")
    public String greetingUser(String username) {
        return "Hello " + username + " from secure app!" ;
    }
}
