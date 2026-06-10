package com.demo.payments.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {

    @NotBlank(message = "el campo 'amount' debe estar completo")
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "el campo 'amount' es inválido")
    private Double amount;

    @NotBlank(message = "el campo 'customerId' debe estar completo")
    @Pattern(regexp = "^\\d+$", message = "el campo 'customerId' es inválido")
    private Long customerId;

}
