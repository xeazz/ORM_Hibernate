package ru.netology.hibernate_layers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate_layers.Entity.Order;
import ru.netology.hibernate_layers.Entity.Person;
import ru.netology.hibernate_layers.service.GetService;
import ru.netology.hibernate_layers.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class OrderController {
    public final OrderService orderService;
    @GetMapping("/fetch-product")
    public List<Order> getProductName(@RequestParam(value = "name") String name) {
        return orderService.getProductName(name);
    }
    }