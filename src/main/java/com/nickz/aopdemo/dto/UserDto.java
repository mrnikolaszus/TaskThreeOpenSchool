package com.nickz.aopdemo.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Set<OrderDto> orders = new HashSet<>();

}