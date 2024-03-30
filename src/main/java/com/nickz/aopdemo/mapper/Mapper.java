package com.nickz.aopdemo.mapper;

public interface Mapper<E, D> {
    E toEntity(D DTO);

    D toDTO(E Entity);
}