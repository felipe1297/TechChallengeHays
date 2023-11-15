package com.hays.hays_order_ms.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Topping {
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Boolean available;
}
