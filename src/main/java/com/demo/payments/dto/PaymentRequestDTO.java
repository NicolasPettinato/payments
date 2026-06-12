package com.demo.payments.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {

    @NotNull(message = "El campo 'amount' es obligatorio")
    @Positive(message = "El campo 'amount' debe ser mayor que cero")
    @Digits(integer = 10, fraction = 2,
            message = "El campo 'amount' debe tener como máximo 10 dígitos enteros y 2 decimales")
    @Schema(example = "12.50")
    private BigDecimal amount;

    @NotNull(message = "el campo 'customerId' debe estar completo")
    @Positive(message = "El campo 'customerId' debe ser mayor que cero")
    @Schema(example = "1")
    private Long customerId;

}
