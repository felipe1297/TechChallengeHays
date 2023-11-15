package com.hays.hays_order_ms.infraestructure.http.controller;

import com.hays.hays_order_ms.application.port.in.ParameterService;
import com.hays.hays_order_ms.infraestructure.http.dto.CustomerDto;
import com.hays.hays_order_ms.infraestructure.http.dto.ParameterDto;
import com.hays.hays_order_ms.infraestructure.http.mapper.ParameterDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hays.hays_order_ms.domain.utilities.Constants.CRUST;
import static com.hays.hays_order_ms.domain.utilities.Constants.SIZE;

@RestController
@RequestMapping("/parameter")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ParameterController {

    private final ParameterService parameterService;
    private final ParameterDtoMapper parameterDtoMapper;

    @PostMapping
    public ResponseEntity<ParameterDto> createParameter(@RequestBody ParameterDto parameterDto) {
        final var response = parameterDtoMapper.parameterToParameterDto(
                parameterService.createParameter(
                        parameterDtoMapper.parameterDtoToParameter(parameterDto)
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParameterDto>> getAllParameter() {
        final var response = parameterDtoMapper.parameterListToParameterDtoList(
                parameterService.getAllParameters()
        );
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParameterDto> getParameterById(@PathVariable Long id) {
        final var response = parameterDtoMapper.parameterToParameterDto(
                parameterService.getParameterById(id)
        );
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ParameterDto>> getParameterByType(@RequestParam String type) {
        final var response = parameterDtoMapper.parameterListToParameterDtoList(
                parameterService.getAllParametersByType(type)
        );
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/size")
    public ResponseEntity<List<ParameterDto>> getSizeTypesParameter() {
        final var response = parameterDtoMapper.parameterListToParameterDtoList(
                parameterService.getAllParametersByType(SIZE)
        );
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/crust")
    public ResponseEntity<List<ParameterDto>> getCrustTypesParameter() {
        final var response = parameterDtoMapper.parameterListToParameterDtoList(
                parameterService.getAllParametersByType(CRUST)
        );
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
