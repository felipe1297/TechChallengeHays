package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.Parameter;

import java.util.List;
import java.util.Optional;

public interface ParameterRepository {
    Parameter createParameter(Parameter parameter);
    List<Parameter> getAllParameters();
    List<Parameter> getAllParametersByType(String type);
    Optional<Parameter> getParameterById(Long id);
}
