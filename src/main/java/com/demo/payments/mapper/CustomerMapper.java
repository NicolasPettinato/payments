package com.demo.payments.mapper;

import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.entity.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {

    public static Customer toEntity(CustomerRequestDTO dto) {
        var c = new Customer();
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        return c;
    }

    public static CustomerResponseDTO toDto(Customer entity) {
        return CustomerResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
