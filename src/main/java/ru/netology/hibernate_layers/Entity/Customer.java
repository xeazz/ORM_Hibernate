package ru.netology.hibernate_layers.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)

    private String surname;
    @Column(nullable = false)
    private int age;
    @Column(unique = true)
    private String phone_number;
    @OneToMany(mappedBy = "customer", cascade=CascadeType.ALL)
    private List<Order> listOrder;

    public Customer(String name, String surname, int age, String phone_number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone_number = phone_number;
    }
}
