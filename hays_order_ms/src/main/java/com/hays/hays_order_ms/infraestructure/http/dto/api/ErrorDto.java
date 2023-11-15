package com.hays.hays_order_ms.infraestructure.http.dto.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ErrorDto {
    private String description;
    private Boolean error;
}
