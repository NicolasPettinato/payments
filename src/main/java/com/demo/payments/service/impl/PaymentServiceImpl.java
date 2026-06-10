package com.demo.payments.service.impl;

import com.demo.payments.repository.PaymentRepository;
import com.demo.payments.repository.StatusRepository;
import com.demo.payments.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final StatusRepository statusRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, StatusRepository statusRepository) {
        this.paymentRepository = paymentRepository;
        this.statusRepository = statusRepository;
    }
}
