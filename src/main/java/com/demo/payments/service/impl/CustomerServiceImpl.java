package com.demo.payments.service.impl;

import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.dto.ErrorCode;
import com.demo.payments.exception.BussinesException;
import com.demo.payments.exception.TechnicalException;
import com.demo.payments.mapper.CustomerMapper;
import com.demo.payments.repository.CustomerRepository;
import com.demo.payments.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        var entity = CustomerMapper.toEntity(dto);
        var customer = customerRepository.getCustomerByEmail(entity.getEmail());
        if (Objects.nonNull(customer)) {
            log.error("el cliente ya se encuentra registrado");
            throw new BussinesException(ErrorCode.CUSTOMER_ALREADY_EXISTS, "el cliente ya se encuentra registrado");
        }

        try {
            var entityResponse = customerRepository.save(entity);
            var response = CustomerMapper.toDto(entityResponse);
            log.info("cliente creado correctamente: {}", response);
            return response;
        } catch (Exception e) {
            String message = "Error interno al crear el cliente";
            log.error(message, e);
            throw new TechnicalException(ErrorCode.INTERNAL_ERROR, message);
        }

    }
}