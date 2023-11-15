package com.hays.hays_order_ms.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Customer {
    private String id;
    private String name;
    private String email;
    @ToString.Exclude
    private String password;
    private String address;
    private String number;
}
