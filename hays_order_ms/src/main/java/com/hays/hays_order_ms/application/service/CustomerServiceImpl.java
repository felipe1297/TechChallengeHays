package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.CustomerService;
import com.hays.hays_order_ms.application.port.out.repository.CustomerRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.Customer;
import com.hays.hays_order_ms.domain.utilities.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public Customer createCustomer(Customer customer) {
        try {
            if(Objects.nonNull(customer.getPassword())) customer.setPassword(Constants.calculateSHA256(customer.getPassword()));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer login(String id, String password) {
        return null;
    }

    @Override
    public Optional<Customer> getById(String id) {
        return customerRepository.findById(id);
    }
}
