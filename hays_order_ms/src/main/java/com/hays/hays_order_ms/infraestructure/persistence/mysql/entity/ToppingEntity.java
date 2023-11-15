package com.hays.hays_order_ms.infraestructure.persistence.mysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "topping")
public class ToppingEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private Double price;
    @Column(name = "available")
    private Boolean available;
}
