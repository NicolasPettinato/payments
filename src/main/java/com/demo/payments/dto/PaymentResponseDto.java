package com.demo.payments.dto;

import com.demo.payments.entity.Customer;
import com.demo.payments.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentResponseDto {

    private Long id;
    private Double amount;
    private Status status;
    private Customer customer;
    private LocalDateTime createdAt;
}
