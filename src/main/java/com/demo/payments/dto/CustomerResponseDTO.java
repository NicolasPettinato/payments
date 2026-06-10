package com.demo.payments.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    @Schema(example = "1")
    private Long id;
    @Schema(example = "nicolas")
    private String name;
    @Schema(example = "nicolas@email.com")
    private String email;
}
