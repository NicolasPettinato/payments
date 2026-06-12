package com.demo.payments.mapper;

import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.entity.Customer;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;

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

    public static List<CustomerResponseDTO> toListDto(List<Customer> entityList) {
        return Objects.isNull(entityList)
                ? List.of()
                : entityList.stream().map(CustomerMapper::toDto).toList();
    }
}
