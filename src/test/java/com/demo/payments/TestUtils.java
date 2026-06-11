package com.demo.payments;

import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.entity.Customer;
import lombok.experimental.UtilityClass;

import static com.demo.payments.TestConstants.*;

@UtilityClass
public class TestUtils {

    public static CustomerRequestDTO mockCustomerRequestDto() {
        return CustomerRequestDTO.builder()
                .name(NAME)
                .email(EMAIL)
                .build();
    }

    public static CustomerResponseDTO mockCustomerResponseDto() {
        return CustomerResponseDTO.builder()
                .id(1L)
                .name(NAME)
                .email(EMAIL)
                .build();
    }

    public static Customer mockCustomer() {
        var customer = new Customer();
        customer.setId(CUSTOMER_ID);
        customer.setName(NAME);
        customer.setEmail(EMAIL);
        return customer;
    }
}
