package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.*;
import com.hays.hays_order_ms.application.port.out.repository.OrderRepository;
import com.hays.hays_order_ms.application.port.out.service.EmailService;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.*;
import com.hays.hays_order_ms.domain.utilities.Constants;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final EmailService emailService;
    private final PizzaCustomizationService pizzaCustomizationService;

    @Transactional
    @Override
    public Order createOrder(@NonNull Order order, @NonNull Payment payment) {

        String orderId = UUID.randomUUID().toString();

        order.setId(orderId);

        if (Objects.isNull(order.getCustomer()) || Objects.isNull(order.getCustomer().getId()) || order.getCustomer().getId().isEmpty())
            throw new BusinessException("Customer is mandatory");

        final var customer = customerService.getById(order.getCustomer().getId()).orElseGet(() -> customerService.createCustomer(order.getCustomer()));
        order.setCustomer(customer);

        final var orderPizza = new Order();
        orderPizza.setId(orderId);
        orderPizza.setCustomer(customer);

        orderRepository.save(orderPizza);

        order.setCustomer(customer);

        List<PizzaCustomization> pizzaCustomizations = new ArrayList<>();

        order.getCustomPizzas().forEach(pizzaCustomization -> {
            pizzaCustomization.setOrder(orderPizza);
            pizzaCustomizations.add(pizzaCustomizationService.createPizzaCustomization(pizzaCustomization));
        });

        order.setCustomPizzas(pizzaCustomizations);

        final var result = orderRepository.save(order);

        payment.setOrder(result);

        paymentService.createPayment(payment);

        emailService.sendOrderConfirmationEmail(order.getCustomer().getEmail(), Constants.createOrderHtml(order));

        return result;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllOrdersByCustomer(String customerId) {
        return orderRepository.findAllOrdersByCustomer(customerId);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

}
