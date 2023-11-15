package com.hays.hays_order_ms.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Promotion {
    private String code;
    private Integer percentage;
    private Boolean available;
    private Date beginDate;
    private Date endDate;
}
