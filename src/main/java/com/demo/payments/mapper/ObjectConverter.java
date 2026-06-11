package com.demo.payments.mapper;

import com.demo.payments.dto.ErrorCode;
import com.demo.payments.exception.TechnicalException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ObjectConverter {

    private final ObjectMapper mapper;

    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Error al convertir objeto a JSON");
            throw new TechnicalException(ErrorCode.JSON_SERIALIZATION_ERROR,
                    "Error al convertir objeto a JSON", e);
        }
    }
}
