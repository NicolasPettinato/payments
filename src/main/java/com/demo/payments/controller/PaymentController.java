package com.demo.payments.controller;

import com.demo.payments.service.PaymentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    POST /payments
//    GET /payments
//    GET /payments/{id}
//    PUT /payments/{id}/approve
//    PUT /payments/{id}/reject
}
