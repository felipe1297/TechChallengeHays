package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(Long paymentId);
    List<Payment> findAll();
}
