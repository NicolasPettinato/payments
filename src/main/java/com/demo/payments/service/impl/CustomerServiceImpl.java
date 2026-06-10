package com.demo.payments.service.impl;

import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.mapper.CustomerMapper;
import com.demo.payments.repository.CustomerRepository;
import com.demo.payments.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        var entity = CustomerMapper.toEntity(dto);
        return CustomerMapper.toDto(customerRepository.save(entity));
    }
}
