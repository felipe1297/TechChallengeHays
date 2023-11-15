package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.CustomerRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.Customer;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.CustomerEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> findById(String id) {
        return customerEntityMapper.customerEntityToCustomer(customerJpaRepository.findById(id));
    }

    @Override
    public List<Customer> findAll() {
        return customerEntityMapper.customerEntityListToCustomerList(customerJpaRepository.findAll());
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerEntityMapper.customerEntityToCustomer(
                customerJpaRepository.save(
                        customerEntityMapper.customerToCustomerEntity(customer)
                )
        );
    }
}
