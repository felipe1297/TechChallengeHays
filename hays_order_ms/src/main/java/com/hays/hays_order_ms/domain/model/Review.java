package com.hays.hays_order_ms.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Review {
    private Long id;
    private Customer customer;
    private Pizza pizza;
    private String description;
    private Date date;
}
