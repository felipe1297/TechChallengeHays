package com.hays.hays_order_ms.infraestructure.http.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class PromotionDto {
    private String code;
    private Integer percentage;
    private Boolean available;
    private Date beginDate;
    private Date endDate;
}
