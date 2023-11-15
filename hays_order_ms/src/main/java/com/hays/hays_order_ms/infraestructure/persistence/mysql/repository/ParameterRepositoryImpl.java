package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.ParameterRepository;
import com.hays.hays_order_ms.domain.model.Parameter;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.ParameterEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.ParameterJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ParameterRepositoryImpl implements ParameterRepository {

    private final ParameterJpaRepository parameterJpaRepository;
    private final ParameterEntityMapper parameterEntityMapper;

    @Transactional
    @Override
    public Parameter createParameter(Parameter parameter) {
        return parameterEntityMapper.parameterEntityToParameter(
                parameterJpaRepository.save(
                        parameterEntityMapper.parameterToParameterEntity(parameter)
                )
        );
    }

    @Override
    public List<Parameter> getAllParameters() {
        return parameterEntityMapper.parameterEntityListToParameterList(
                parameterJpaRepository.findAll()
        );
    }

    @Override
    public List<Parameter> getAllParametersByType(String type) {
        return parameterEntityMapper.parameterEntityListToParameterList(
                parameterJpaRepository.findAllByType(type)
        );
    }

    @Override
    public Optional<Parameter> getParameterById(Long id) {
        return parameterEntityMapper.parameterEntityToParameter(
                parameterJpaRepository.findById(id)
        );
    }
}
