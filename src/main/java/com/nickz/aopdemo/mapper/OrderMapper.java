package com.nickz.aopdemo.mapper;

import com.nickz.aopdemo.dto.OrderDto;
import com.nickz.aopdemo.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<Order, OrderDto> {

    @Override
    public Order toEntity(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setDescription(dto.getDescription());
        order.setStatus(dto.getStatus());
        return order;
    }

    @Override
    public OrderDto toDTO(Order entity) {
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setUserId(entity.getUser() != null ? entity.getUser().getId() : null);
        return dto;
    }
}