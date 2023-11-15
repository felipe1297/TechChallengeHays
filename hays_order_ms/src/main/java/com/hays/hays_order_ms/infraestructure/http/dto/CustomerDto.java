package com.hays.hays_order_ms.infraestructure.http.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String number;
}
