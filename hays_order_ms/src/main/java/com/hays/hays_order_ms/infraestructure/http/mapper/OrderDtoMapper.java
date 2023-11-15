package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.Order;
import com.hays.hays_order_ms.infraestructure.http.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ParameterDtoMapper.class})
public interface OrderDtoMapper {
    OrderDto orderToOrderDto(Order order);
    List<OrderDto> orderListToOrderDtoList(List<Order> order);
    Order orderDtoToOrder(OrderDto orderDto);
    List<Order> orderDtoListToOrderList(List<OrderDto> orderDto);
}
