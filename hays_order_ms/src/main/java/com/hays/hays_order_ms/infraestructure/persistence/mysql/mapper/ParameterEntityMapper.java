package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.Parameter;
import com.hays.hays_order_ms.infraestructure.http.dto.ParameterDto;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.ParameterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ParameterEntityMapper {
    default Optional<ParameterEntity> parameterToParameterEntity(Optional<Parameter> parameter) {
        return parameter.map(this::parameterToParameterEntity);
    }
    ParameterEntity parameterToParameterEntity(Parameter parameter);
    List<ParameterEntity> parameterListToParameterEntityList(List<Parameter> parameter);
    default Optional<Parameter> parameterEntityToParameter(Optional<ParameterEntity> parameterEntity) {
        return parameterEntity.map(this::parameterEntityToParameter);
    }
    Parameter parameterEntityToParameter(ParameterEntity parameterEntity);
    List<Parameter> parameterEntityListToParameterList(List<ParameterEntity> parameterEntity);
}
