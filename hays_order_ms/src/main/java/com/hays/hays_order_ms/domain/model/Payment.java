package com.hays.hays_order_ms.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Payment {
    private Long id;
    private Order order;
    private String method;
    private String status;
    private Promotion promotion;
    private Double amount;
    private Double finalAmount;
    private Date date = new Date();
}
