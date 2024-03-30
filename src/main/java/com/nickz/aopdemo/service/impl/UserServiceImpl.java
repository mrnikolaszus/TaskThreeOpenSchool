package com.nickz.aopdemo.service.impl;

import com.nickz.aopdemo.dto.OrderDto;
import com.nickz.aopdemo.dto.UserDto;
import com.nickz.aopdemo.entity.Order;
import com.nickz.aopdemo.entity.User;
import com.nickz.aopdemo.exception.EntityNotFoundException;
import com.nickz.aopdemo.mapper.OrderMapper;
import com.nickz.aopdemo.mapper.UserAllMapper;
import com.nickz.aopdemo.mapper.UserMapper;
import com.nickz.aopdemo.repository.OrderRepository;
import com.nickz.aopdemo.repository.UserRepository;
import com.nickz.aopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserAllMapper userAllMapper;
    private final OrderRepository orderRepository;


    private final OrderMapper orderMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserAllMapper userAllMapper, OrderRepository orderRepository, OrderMapper orderMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userAllMapper = userAllMapper;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }



    @Transactional
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        if (userDto.getOrders() != null && !userDto.getOrders().isEmpty()) {
            for (OrderDto orderDto : userDto.getOrders()) {
                orderDto.setUserId(user.getId());
                Order order = orderMapper.toEntity(orderDto);
                order.setUser(user);
                orderRepository.save(order);
            }
        }
        return userMapper.toDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        Set<Order> orders = new HashSet<>(orderRepository.findByUserId(user.getId()));
        user.setOrders(orders);
        return userMapper.toDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userAllMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
