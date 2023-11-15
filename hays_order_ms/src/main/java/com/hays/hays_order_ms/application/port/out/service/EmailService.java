package com.hays.hays_order_ms.application.port.out.service;

public interface EmailService {
    void sendOrderConfirmationEmail(String to, String orderDetails);
}
