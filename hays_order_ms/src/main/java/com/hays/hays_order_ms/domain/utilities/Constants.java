package com.hays.hays_order_ms.domain.utilities;

import com.hays.hays_order_ms.domain.model.Order;
import com.hays.hays_order_ms.domain.model.PizzaCustomization;
import com.hays.hays_order_ms.domain.model.Topping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Constants {
    public static final String CRUST = "Crust";
    public static final String SIZE = "Size";

    public static double roundDouble(double a){
        BigDecimal bd = new BigDecimal(Double.toString(a));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String calculateSHA256(String texto) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(texto.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String createOrderHtml(Order order) {
        StringBuilder html = new StringBuilder();

        html.append("<html><body>");
        html.append("<h1>Order detail</h1>");
        html.append("<p><strong>Order id:</strong> ").append(order.getId()).append("</p>");
        html.append("<p><strong>Customer:</strong> ").append(order.getCustomer().getName()).append("</p>");
        html.append("<p><strong>Address:</strong> ").append(order.getCustomer().getAddress()).append("</p>");
        html.append("<h2>Custom pizzas</h2>");
        html.append("<ul>");

        for (PizzaCustomization pizzaCustom : order.getCustomPizzas()) {
            html.append("<li>");
            html.append("<p>Pizza id: ").append(pizzaCustom.getPizza().getId()).append("</p>");
            html.append("<p>Toppings: ");
            for (Topping topping : pizzaCustom.getToppings()) {
                html.append(topping.getName()).append(", ");
            }
            html.append("</p>");
            html.append("<p>Size: ").append(pizzaCustom.getSize().getValue()).append("</p>");
            html.append("<p>Crust: ").append(pizzaCustom.getCrust().getValue()).append("</p>");
            html.append("</li>");
        }

        html.append("</ul></body></html>");

        return html.toString();
    }


}
