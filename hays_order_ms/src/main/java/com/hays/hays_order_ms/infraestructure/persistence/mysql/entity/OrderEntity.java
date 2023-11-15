package com.hays.hays_order_ms.infraestructure.persistence.mysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order")
    private List<PizzaCustomizationEntity> customPizzas;
}
