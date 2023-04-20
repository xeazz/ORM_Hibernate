package ru.netology.hibernate_layers.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private String date;
    private int amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(String product_name, int amount, int customer_id, String date) {
        this.product_name = product_name;
        this.amount = amount;
        this.date = date;
    }
}
