package com.hays.hays_order_ms.infraestructure.http.controller;

import com.hays.hays_order_ms.application.port.in.PizzaService;
import com.hays.hays_order_ms.infraestructure.http.dto.PizzaDto;
import com.hays.hays_order_ms.infraestructure.http.mapper.PizzaDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PizzaController {

    private final PizzaService pizzaService;
    private final PizzaDtoMapper pizzaDtoMapper;


    @PostMapping
    public ResponseEntity<PizzaDto> createPizza(@RequestBody PizzaDto pizzaDto){
        final var pizza = pizzaDtoMapper.pizzaDtoToPizza(pizzaDto);
        final var result = pizzaService.createPizza(pizza);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pizzaDtoMapper.pizzaToPizzaDto(result));
    }

    @GetMapping("/name/{name}/{limit}")
    public ResponseEntity<List<PizzaDto>> getXPizzasByName(@PathVariable String name, @PathVariable int limit){
        return ResponseEntity.ok(pizzaDtoMapper.pizzaListToPizzaDtoList(pizzaService.getXPizzasByName(name, limit)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PizzaDto>> getAllPizzas(){
        return ResponseEntity.ok(pizzaDtoMapper.pizzaListToPizzaDtoList(pizzaService.getAllPizzas()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDto> getPizzaById(Long id){
        return ResponseEntity.ok(pizzaDtoMapper.pizzaToPizzaDto(pizzaService.getPizzaById(id)));
    }

}
