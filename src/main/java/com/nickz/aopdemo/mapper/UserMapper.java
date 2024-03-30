package com.nickz.aopdemo.mapper;

import com.nickz.aopdemo.dto.UserDto;
import com.nickz.aopdemo.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    private final OrderMapper orderMapper = new OrderMapper();

    @Override
    public User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        if (dto.getOrders() != null) {
            user.setOrders(dto.getOrders().stream().map(orderMapper::toEntity).collect(Collectors.toSet()));
        }
        return user;
    }

    @Override
    public UserDto toDTO(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        if (entity.getOrders() != null) {
            dto.setOrders(entity.getOrders().stream().map(orderMapper::toDTO).collect(Collectors.toSet()));
        }
        return dto;
    }
}
