package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.PaymentService;
import com.hays.hays_order_ms.application.port.in.PromotionService;
import com.hays.hays_order_ms.application.port.out.repository.PaymentRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.Payment;
import com.hays.hays_order_ms.domain.model.Promotion;
import com.hays.hays_order_ms.domain.model.Topping;
import com.hays.hays_order_ms.domain.utilities.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PromotionService promotionService;

    @Transactional
    @Override
    public Payment createPayment(Payment payment) {

        var promotion = payment.getPromotion();

        if (Objects.nonNull(promotion) && Objects.nonNull(promotion.getCode()) && !promotion.getCode().isEmpty()) {
            final var promotionDb = promotionService.findById(promotion.getCode()).orElseThrow(() -> new BusinessException("Promotion does not exists"));
            if (Boolean.FALSE.equals(promotionDb.getAvailable()))
                throw new BusinessException("Promotion is not available");
            payment.setPromotion(promotionDb);
        }

        verifyPrice(payment, payment.getPromotion());

        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void verifyPrice(Payment payment, Promotion promotion) {

        if (Objects.isNull(payment.getOrder()))
            throw new BusinessException("Order is mandatory");

        double total = payment.getOrder().getCustomPizzas().stream()
                .mapToDouble(pizzaCustomization -> {
                    Double toppingsPrice = pizzaCustomization.getToppings().stream()
                            .peek(topping -> {
                                if (!topping.getAvailable())
                                    throw new BusinessException("Topping is not available");
                            })
                            .mapToDouble(Topping::getPrice)
                            .sum();
                    double crust = Double.parseDouble(pizzaCustomization.getCrust().getValue());
                    double size = Double.parseDouble(pizzaCustomization.getSize().getValue());
                    return (pizzaCustomization.getPizza().getBasePrice() + toppingsPrice) * (1 + crust + size);
                })
                .sum();

        payment.setAmount(total);

        double totalWithPromotion = (Objects.nonNull(promotion) && promotion.getAvailable()) ?
                Constants.roundDouble(total * (1 - (promotion.getPercentage().doubleValue() / 100L))) : total;

        payment.setFinalAmount(totalWithPromotion);

    }
}
