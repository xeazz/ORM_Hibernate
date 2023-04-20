package ru.netology.hibernate_layers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.Entity.PersonFirstKey;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@SpringBootApplication
public class HibernateLayersApplication implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(HibernateLayersApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        List<String> cities = List.of("Saint-Petersburg", "Moscow", "Yekaterinburg", "Novosibirsk");
        List<String> names = List.of("Ivan", "Pavel", "Anton", "Dima", "Slava", "Viktor");
        List<String> surnames = List.of("Pavlov", "Viktorov", "Semenov", "Petrov", "Vovochkin", "Ivanov");
        Random random = new Random();
        IntStream.range(0, 10)
                .forEach(x -> {
                        Person person = Person.builder()
                        .personFirstKey(PersonFirstKey.builder()
                                .name(names.get(ThreadLocalRandom.current().nextInt(names.size())))
                                .age(ThreadLocalRandom.current().nextInt(0, 100))
                                .surname(surnames.get(ThreadLocalRandom.current().nextInt(surnames.size())))
                                .build())
                        .city_in_living(cities.get(ThreadLocalRandom.current().nextInt(cities.size())))
                        .phone_number("8999-222-33-1" + ThreadLocalRandom.current().nextInt(10, 99))
                        .build();
                    entityManager.persist(person);
                });


    }
}
