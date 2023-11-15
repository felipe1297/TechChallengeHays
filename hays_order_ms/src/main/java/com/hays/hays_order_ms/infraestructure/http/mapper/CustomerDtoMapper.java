package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.Customer;
import com.hays.hays_order_ms.infraestructure.http.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    List<CustomerDto> customerListToCustomerDtoList(List<Customer> customers);
    Customer customerDtoToCustomer(CustomerDto customerDto);
    List<Customer> customerDtoListToCustomerList(List<CustomerDto> customerDtos);

}
