package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.Payment;
import com.hays.hays_order_ms.infraestructure.http.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentDtoMapper {
    PaymentDto paymentToPaymentDto(Payment payment);
    List<PaymentDto> paymentListToPaymentDtoList(List<Payment> payment);
    Payment paymentDtoToPayment(PaymentDto paymentDto);
    List<Payment> paymentDtoListToPaymentList(List<PaymentDto> paymentDto);
}
