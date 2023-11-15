package com.hays.hays_order_ms.infraestructure.http.controller;

import com.hays.hays_order_ms.application.port.in.CustomerService;
import com.hays.hays_order_ms.infraestructure.http.dto.CustomerDto;
import com.hays.hays_order_ms.infraestructure.http.mapper.CustomerDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDtoMapper customerDtoMapper;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        final var customer = customerDtoMapper.customerDtoToCustomer(customerDto);
        final var result = customerService.createCustomer(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerDtoMapper.customerToCustomerDto(result));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerDtoMapper.customerListToCustomerDtoList(customerService.getAllCustomers()));
    }

}
