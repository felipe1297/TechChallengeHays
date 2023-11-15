package com.hays.hays_order_ms.infraestructure.http.controller;

import com.hays.hays_order_ms.application.port.in.OrderService;
import com.hays.hays_order_ms.infraestructure.http.dto.OrderDto;
import com.hays.hays_order_ms.infraestructure.http.dto.api.OrderDtoApi;
import com.hays.hays_order_ms.infraestructure.http.mapper.OrderDtoMapper;
import com.hays.hays_order_ms.infraestructure.http.mapper.PaymentDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;
    private final OrderDtoMapper orderDtoMapper;
    private final PaymentDtoMapper paymentDtoMapper;

    @PostMapping
    public ResponseEntity<OrderDto> createCustomer(@RequestBody OrderDtoApi orderDtoApi) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderDtoMapper.orderToOrderDto(
                        orderService.createOrder(
                                        orderDtoMapper.orderDtoToOrder(orderDtoApi.getOrderDto()),
                                        paymentDtoMapper.paymentDtoToPayment(orderDtoApi.getPaymentDto())
                                ))
                );
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderDtoMapper.orderListToOrderDtoList(
                        orderService.findAllOrder()
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderDtoMapper.orderToOrderDto(
                        orderService.findById(id)
                ));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomer(@RequestParam String customerId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderDtoMapper.orderListToOrderDtoList(
                        orderService.findAllOrdersByCustomer(customerId)
                ));
    }

}
