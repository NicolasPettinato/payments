package com.demo.payments.controller;

import com.demo.payments.service.CustomerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    POST /customers
//    GET /customers

}
