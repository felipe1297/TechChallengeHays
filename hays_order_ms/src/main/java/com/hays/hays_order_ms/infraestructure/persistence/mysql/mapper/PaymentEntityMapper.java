package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.Payment;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {
    default Optional<Payment> paymentEntityToPayment(Optional<PaymentEntity> paymentEntity) {
        return paymentEntity.map(this::paymentEntityToPayment);
    }
    Payment paymentEntityToPayment(PaymentEntity paymentEntity);
    List<Payment> paymentEntityListToPaymentList(List<PaymentEntity> paymentEntity);
    default Optional<PaymentEntity> paymentToPaymentEntity(Optional<Payment> payment) {
        return payment.map(this::paymentToPaymentEntity);
    }
    PaymentEntity paymentToPaymentEntity(Payment payment);
    List<PaymentEntity> paymentListToPaymentEntityList(List<Payment> payment);
}
