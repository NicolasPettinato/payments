package com.demo.payments.mapper;

import com.demo.payments.dto.PaymentRequestDTO;
import com.demo.payments.dto.PaymentResponseDto;
import com.demo.payments.entity.Payment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {

    public static Payment toEntity(PaymentRequestDTO dto) {
        var payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.getCustomer().setId(dto.getCustomerId());
        return payment;
    }

    public static PaymentResponseDto toDto(Payment entity) {
        return PaymentResponseDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .customer(entity.getCustomer())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
