package com.hays.hays_order_ms.infraestructure.http.dto.api;

import com.hays.hays_order_ms.infraestructure.http.dto.OrderDto;
import com.hays.hays_order_ms.infraestructure.http.dto.PaymentDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderDtoApi {
    private OrderDto orderDto;
    private PaymentDto paymentDto;
    private String codePromotion;
}
