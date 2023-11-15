package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.PizzaService;
import com.hays.hays_order_ms.application.port.out.repository.PizzaRepository;
import com.hays.hays_order_ms.domain.model.Pizza;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;


    @Transactional
    @Override
    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getXPizzasByName(String name, Integer number) {
        return pizzaRepository.findByNameTop(name, number);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id);
    }
}
