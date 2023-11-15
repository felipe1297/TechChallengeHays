package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.OrderRepository;
import com.hays.hays_order_ms.domain.model.Order;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.OrderEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.OrderJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderEntityMapper orderEntityMapper;


    @Transactional
    @Override
    public Order save(Order order) {
        return orderEntityMapper.orderEntityToOrder(
                orderJpaRepository.save(
                        orderEntityMapper.orderToOrderEntity(order)
                )
        );
    }

    @Override
    public Order findById(Long id) {
        return orderEntityMapper.orderEntityToOrder(orderJpaRepository.getById(id));
    }

    @Override
    public List<Order> findAllOrdersByCustomer(String customerId) {
        return orderEntityMapper.orderEntityListToOrderList(
                orderJpaRepository.findAllByCustomerId(customerId)
        );
    }

    @Override
    public List<Order> findAll() {
        return orderEntityMapper.orderEntityListToOrderList(
                orderJpaRepository.findAll()
        );
    }

}
