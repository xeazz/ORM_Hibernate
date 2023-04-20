package ru.netology.hibernate_layers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.hibernate_layers.Entity.Order;
import ru.netology.hibernate_layers.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getProductName(String name) {
        return orderRepository.getProductName(name);
    }
}
