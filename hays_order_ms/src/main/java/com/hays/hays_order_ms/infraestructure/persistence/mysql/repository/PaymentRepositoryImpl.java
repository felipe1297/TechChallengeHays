package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.PaymentRepository;
import com.hays.hays_order_ms.domain.model.Payment;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.PaymentEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.PaymentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentEntityMapper paymentEntityMapper;

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return paymentEntityMapper.paymentEntityToPayment(
                paymentJpaRepository.save(
                        paymentEntityMapper.paymentToPaymentEntity(payment)
                )
        );
    }

    @Override
    public Optional<Payment> findById(Long paymentId) {
        return paymentEntityMapper.paymentEntityToPayment(
                paymentJpaRepository.findById(paymentId)
        );
    }

    @Override
    public List<Payment> findAll() {
        return paymentEntityMapper.paymentEntityListToPaymentList(
                paymentJpaRepository.findAll()
        );
    }
}
