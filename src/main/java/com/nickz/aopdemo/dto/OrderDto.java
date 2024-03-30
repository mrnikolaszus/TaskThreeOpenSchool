package com.nickz.aopdemo.dto;

import com.nickz.aopdemo.entity.OrderStatus;
import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private String description;
    private OrderStatus status;
    private Long userId;
}
