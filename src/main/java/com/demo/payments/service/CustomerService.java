package com.demo.payments.service;

import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO dto);

    List<CustomerResponseDTO> getCostumers();

    Customer getById(Long customerId);
}
