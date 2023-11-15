package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.Payment;
import com.hays.hays_order_ms.domain.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Optional<Payment> findById(Long paymentId);
    List<Payment> findAll();

    void verifyPrice(Payment payment, Promotion promotion);
}
