package com.demo.payments.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
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
public class CustomerRequestDTO {

    @NotBlank(message = "el campo 'name' debe estar completo")
    @Pattern(regexp = "^[A-Za-z]+$", message = "el campo 'name' debe contener solo letras")
    @Schema(example = "Nicolas")
    private String name;

    @NotBlank(message = "el campo 'email' debe estar completo")
    @Email(message = "el campo 'email' tiene formato incorrecto")
    @Schema(example = "nicolas@email.com")
    private String email;
}
