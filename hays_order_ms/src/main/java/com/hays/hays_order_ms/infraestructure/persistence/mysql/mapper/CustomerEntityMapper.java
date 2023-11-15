package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.Customer;
import com.hays.hays_order_ms.domain.model.Payment;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.CustomerEntity;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    default Optional<CustomerEntity> customerToCustomerEntity(Optional<Customer> customer) {
        return customer.map(this::customerToCustomerEntity);
    }
    CustomerEntity customerToCustomerEntity(Customer customer);
    List<CustomerEntity> customerListToCustomerEntityList(List<Customer> customers);
    default Optional<Customer> customerEntityToCustomer(Optional<CustomerEntity> customerEntity) {
        return customerEntity.map(this::customerEntityToCustomer);
    }
    Customer customerEntityToCustomer(CustomerEntity customerEntity);
    List<Customer> customerEntityListToCustomerList(List<CustomerEntity> customerEntities);
}
