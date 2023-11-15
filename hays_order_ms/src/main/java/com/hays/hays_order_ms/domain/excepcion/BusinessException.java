package com.hays.hays_order_ms.domain.excepcion;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
