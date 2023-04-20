package ru.netology.hibernate_layers.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.hibernate_layers.Entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getProductName(String name);
}
