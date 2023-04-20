package ru.netology.hibernate_layers.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_layers.Entity.Order;

import java.util.List;
@Repository
public class OrderRepositoryImpl implements OrderRepository{
    @PersistenceContext
    private EntityManager entityManager;
    private static final String QUERY = "SELECT o.product_name FROM Order o JOIN Customer c ON o.customer = c.id WHERE UPPER(c.name) = :name";
    @Override
    public List<Order> getProductName(String name) {
        return entityManager.createQuery(QUERY)
                .setParameter("name", name)
                .getResultList();
    }
}
