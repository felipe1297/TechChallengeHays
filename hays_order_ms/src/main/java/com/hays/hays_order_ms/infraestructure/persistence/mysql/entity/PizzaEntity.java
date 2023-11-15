package com.hays.hays_order_ms.infraestructure.persistence.mysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "pizza")
public class PizzaEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "basePrice")
    private Double basePrice;
}
