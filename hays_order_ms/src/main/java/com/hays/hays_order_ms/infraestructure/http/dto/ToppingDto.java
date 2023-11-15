package com.hays.hays_order_ms.infraestructure.http.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ToppingDto {
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Boolean available;
}
