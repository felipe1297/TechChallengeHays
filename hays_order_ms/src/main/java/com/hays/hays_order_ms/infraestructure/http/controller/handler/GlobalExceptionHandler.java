package com.hays.hays_order_ms.infraestructure.http.controller.handler;

import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.infraestructure.http.dto.api.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> handleYourSpecificException(BusinessException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorDto.builder()
                        .description(e.getMessage())
                        .error(Boolean.TRUE)
                        .build());
    }

}
