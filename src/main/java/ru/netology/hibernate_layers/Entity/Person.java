package ru.netology.hibernate_layers.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @EmbeddedId
    private PersonFirstKey personFirstKey;
    private String phone_number;
    private String city_in_living;
}
