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
public class HibernateLayersApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateLayersApplication.class, args);
    }

}
