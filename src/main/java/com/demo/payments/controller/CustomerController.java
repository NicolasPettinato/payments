package com.demo.payments.controller;

import com.demo.payments.dto.CustomerRequestDTO;
import com.demo.payments.dto.CustomerResponseDTO;
import com.demo.payments.dto.ErrorResponse;
import com.demo.payments.mapper.ObjectConverter;
import com.demo.payments.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.source.spi.IdentifierSourceAggregatedComposite;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ObjectConverter objectConverter;

    //    POST /customers
    @PostMapping
    @Operation(summary = "crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = CustomerResponseDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "bad request", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)
            )),
            @ApiResponse(responseCode = "500", description = "Error interno del servicio", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)
            )),
    })
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO requestDTO) {
        log.info("Request: {}", objectConverter.toJson(requestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                customerService.createCustomer(requestDTO));
    }

    //    GET /customers
    @GetMapping
    @Operation(summary = "Devuelve listado de clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = CustomerResponseDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "bad request", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)
            )),
            @ApiResponse(responseCode = "500", description = "Error interno del servicio", content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)
            )),
    })
    public ResponseEntity<List<CustomerResponseDTO>> createCustomer() {
        return ResponseEntity.ok().body(customerService.getCostumers());
    }
}
