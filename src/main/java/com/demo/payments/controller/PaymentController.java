package com.demo.payments.controller;

import com.demo.payments.dto.*;
import com.demo.payments.mapper.ObjectConverter;
import com.demo.payments.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final ObjectConverter objectConverter;

    //    POST /payments
    @PostMapping
    @Operation(summary = "crear un nuevo pago")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pago creado exitosamente", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = PaymentResponseDto.class)
            )),
            @ApiResponse(responseCode = "400", description = "bad request", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)
            )),
            @ApiResponse(responseCode = "500", description = "Error interno del servicio", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)
            )),
    })
    public ResponseEntity<PaymentResponseDto> createPayment(@Valid @RequestBody PaymentRequestDTO requestDTO) {
        log.info("Request: {}", objectConverter.toJson(requestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                paymentService.createPayment(requestDTO));
    }

//    GET /payments
//    GET /payments/{id}
//    PUT /payments/{id}/approve
//    PUT /payments/{id}/reject
}
