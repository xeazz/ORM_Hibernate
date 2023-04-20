package ru.netology.hibernate_layers.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_layers.Entity.Person;

import java.util.List;

@Repository
public class GetRepositoryImpl implements GetRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static final String QUERY = "SELECT personFirstKey.name FROM Person p WHERE p.city_in_living = :city";

    @Override
    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery(QUERY)
                .setParameter("city", city)
                .getResultList();
    }
}
