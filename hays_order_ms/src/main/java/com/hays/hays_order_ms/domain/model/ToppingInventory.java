package com.hays.hays_order_ms.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ToppingInventory {
    private Long id;
    private Topping topping;
    private Integer quantity;
    private Integer orderThreshold;
    private String supplier;
}
