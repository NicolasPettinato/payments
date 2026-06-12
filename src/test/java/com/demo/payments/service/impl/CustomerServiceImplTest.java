package com.demo.payments.service.impl;

import com.demo.payments.TestUtils;
import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.entity.Customer;
import com.demo.payments.exception.BusinessException;
import com.demo.payments.exception.TechnicalException;
import com.demo.payments.mapper.ObjectConverter;
import com.demo.payments.repository.CustomerRepository;
import com.demo.payments.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.w3c.dom.stylesheets.LinkStyle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
class CustomerServiceImplTest {

    private CustomerRepository customerRepository;
    private CustomerService customerService;
    private CustomerRequestDTO requestDTO;
    private CustomerResponseDTO responseDTO;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
        requestDTO = TestUtils.mockCustomerRequestDto();
        responseDTO = TestUtils.mockCustomerResponseDto();
        customer = TestUtils.mockCustomer();
    }

    @Test
    void createCustomer() {
        when(customerRepository.save(any())).thenReturn(customer);
        var response = customerService.createCustomer(requestDTO);

        assertNotNull(response);
        assertEquals(responseDTO, response);
    }

    @Test
    void createCustomer_already_exists() {
        when(customerRepository.getCustomerByEmail(any())).thenReturn(customer);

        assertThrows(BusinessException.class, () -> customerService.createCustomer(requestDTO));
    }

    @Test
    void createCustomer_db_error() {
        when(customerRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        assertThrows(TechnicalException.class, () -> customerService.createCustomer(requestDTO));
    }

    @Test
    void getCustomerList_nonEmpty() {
        List<Customer> list = List.of(customer, customer);
        when(customerRepository.findAll()).thenReturn(list);

        var response = customerService.getCostumers();
        assertEquals(2, response.size());
    }

    @Test
    void getCustomerList_empty() {
        when(customerRepository.findAll()).thenReturn(List.of());

        var response = customerService.getCostumers();
        assertEquals(0, response.size());
    }
}