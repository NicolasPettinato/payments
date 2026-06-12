package com.demo.payments.service.impl;

import com.demo.payments.dto.ErrorCode;
import com.demo.payments.dto.PaymentRequestDTO;
import com.demo.payments.dto.PaymentResponseDto;
import com.demo.payments.exception.BusinessException;
import com.demo.payments.mapper.PaymentMapper;
import com.demo.payments.repository.PaymentRepository;
import com.demo.payments.repository.StatusRepository;
import com.demo.payments.service.CustomerService;
import com.demo.payments.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.demo.payments.utils.Constants.STATUS_PENDING;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerService customerService;
    private final StatusRepository statusRepository;

    @Transactional
    @Override
    public PaymentResponseDto createPayment(PaymentRequestDTO requestDTO) {
        var customer = customerService.getById(requestDTO.getCustomerId());
        var status = statusRepository.findById(STATUS_PENDING)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND, "No se encontró el estado PENDING"));

        var entity = PaymentMapper.toEntity(requestDTO, customer);
        entity.setCustomer(customer);
        entity.setStatus(status);
        entity.setCreatedAt(LocalDateTime.now());

        entity = paymentRepository.save(entity);

        return PaymentMapper.toDto(entity);
    }
}
