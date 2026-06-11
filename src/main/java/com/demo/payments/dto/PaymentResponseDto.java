package com.demo.payments.dto;

import com.demo.payments.entity.Customer;
import com.demo.payments.entity.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentResponseDto {

    @Schema(example = "1")
    private Long id;
    @Schema(example = "12.50")
    private BigDecimal amount;
    private Status status;
    private Customer customer;
    @Schema(example = "2026-06-10T18:36:58.000")
    private LocalDateTime createdAt;
}
