package com.demo.payments.service;

import com.demo.payments.dto.PaymentRequestDTO;
import com.demo.payments.dto.PaymentResponseDto;
import jakarta.validation.Valid;

public interface PaymentService {

    PaymentResponseDto createPayment(PaymentRequestDTO requestDTO);

}
