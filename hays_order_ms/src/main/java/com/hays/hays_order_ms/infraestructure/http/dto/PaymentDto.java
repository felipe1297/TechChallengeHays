package com.hays.hays_order_ms.infraestructure.http.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class PaymentDto {
    private Long id;
    private OrderDto order;
    private String method;
    private String status;
    private PromotionDto promotion;
    private Double amount;
    private Double finalAmount;
    private Date date;
}
