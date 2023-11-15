package com.hays.hays_order_ms.infraestructure.smtp.service;

import com.hays.hays_order_ms.application.port.out.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendOrderConfirmationEmail(String to, String orderDetails) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
        try {
            helper.setFrom("noreply@example.com");
            helper.setTo(to);
            helper.setSubject("Order detail");
            helper.setText(orderDetails, true);

            emailSender.send(message);
        } catch (MessagingException e) {
            System.out.println();
        }
    }
}
