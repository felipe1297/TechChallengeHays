package com.hays.hays_order_ms.infraestructure.http.controller;

import com.hays.hays_order_ms.application.port.in.ToppingService;
import com.hays.hays_order_ms.infraestructure.http.dto.ToppingDto;
import com.hays.hays_order_ms.infraestructure.http.mapper.ToppingDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topping")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ToppingController {

    private final ToppingService toppingService;
    private final ToppingDtoMapper toppingDtoMapper;

    @PostMapping
    public ResponseEntity<ToppingDto> createIngredient(@RequestBody ToppingDto toppingDto){
        final var ingredient = toppingDtoMapper.ingredientDtoToIngredient(toppingDto);
        final var result = toppingService.creatIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toppingDtoMapper.ingredientToIngredientDto(result));
    }

    @GetMapping("/name/{name}/{limit}")
    public ResponseEntity<List<ToppingDto>> getXPizzasByName(@PathVariable String name, @PathVariable int limit){
        return ResponseEntity.ok(toppingDtoMapper.ingredientListToIngredientDtoList(toppingService.getXIngredientByName(name, limit)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToppingDto> getPizzaById(Long id){
        return ResponseEntity.ok(toppingDtoMapper.ingredientToIngredientDto(toppingService.getIngredientById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToppingDto>> getAll(){
        return ResponseEntity.ok(toppingDtoMapper.ingredientListToIngredientDtoList(toppingService.getAll()));
    }

}
