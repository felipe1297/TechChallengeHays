package com.hays.hays_order_ms.infraestructure.persistence.mysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    @Column(name = "method")
    private String method;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = true)
    private PromotionEntity promotion;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "finalAmount")
    private Double finalAmount;
    @Column(name = "date")
    private Date date;
}
