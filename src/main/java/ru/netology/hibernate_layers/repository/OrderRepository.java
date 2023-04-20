package ru.netology.hibernate_layers.repository;

import ru.netology.hibernate_layers.Entity.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getProductName (String name);
}
