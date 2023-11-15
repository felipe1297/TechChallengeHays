package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.ParameterService;
import com.hays.hays_order_ms.application.port.out.repository.ParameterRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParameterServiceImpl implements ParameterService {

    private final ParameterRepository parameterRepository;


    @Transactional
    @Override
    public Parameter createParameter(Parameter parameter) {
        return parameterRepository.createParameter(parameter);
    }

    @Override
    public List<Parameter> getAllParameters() {
        return parameterRepository.getAllParameters();
    }

    @Override
    public List<Parameter> getAllParametersByType(String type) {
        return parameterRepository.getAllParametersByType(type);
    }

    @Override
    public Parameter getParameterById(Long id) {
        return parameterRepository.getParameterById(id)
                .orElseThrow(() -> new BusinessException("Parameter does not exist"));
    }
}
