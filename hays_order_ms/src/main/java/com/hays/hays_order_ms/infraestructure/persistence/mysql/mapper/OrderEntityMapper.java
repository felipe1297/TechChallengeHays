package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.Order;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ParameterEntityMapper.class})
public interface OrderEntityMapper {
    Order orderEntityToOrder(OrderEntity orderEntity);
    List<Order> orderEntityListToOrderList(List<OrderEntity> orderEntity);
    OrderEntity orderToOrderEntity(Order order);
    List<OrderEntity> orderListToOrderEntityList(List<Order> order);
}
