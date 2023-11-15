package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.Parameter;
import com.hays.hays_order_ms.infraestructure.http.dto.ParameterDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ParameterDtoMapper {
    default Optional<Parameter> parameterDtoToParameter(Optional<ParameterDto> parameterDto) {
        return parameterDto.map(this::parameterDtoToParameter);
    }
    Parameter parameterDtoToParameter(ParameterDto parameterDto);
    List<Parameter> parameterDtoListToParameterList(List<ParameterDto> parameterDto);
    default Optional<ParameterDto> parameterToParameterDto(Optional<Parameter> parameter) {
        return parameter.map(this::parameterToParameterDto);
    }
    ParameterDto parameterToParameterDto(Parameter parameter);
    List<ParameterDto> parameterListToParameterDtoList(List<Parameter> parameter);
}
