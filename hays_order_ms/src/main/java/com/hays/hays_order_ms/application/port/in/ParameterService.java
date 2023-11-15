package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.Parameter;

import java.util.List;
import java.util.Optional;

public interface ParameterService {
    Parameter createParameter(Parameter parameter);
    List<Parameter> getAllParameters();
    List<Parameter> getAllParametersByType(String type);
    Parameter getParameterById(Long id);
}
