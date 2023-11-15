package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.ParameterService;
import com.hays.hays_order_ms.application.port.in.PizzaCustomizationService;
import com.hays.hays_order_ms.application.port.in.PizzaService;
import com.hays.hays_order_ms.application.port.in.ToppingService;
import com.hays.hays_order_ms.application.port.out.repository.PizzaCustomizationRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.PizzaCustomization;
import com.hays.hays_order_ms.domain.model.Topping;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class PizzaCustomizationServiceImpl implements PizzaCustomizationService {

    private final PizzaCustomizationRepository pizzaCustomizationRepository;
    private final ToppingService toppingService;
    private final ParameterService parameterService;
    private final PizzaService pizzaService;


    @Transactional
    @Override
    public PizzaCustomization createPizzaCustomization(PizzaCustomization pizzaCustomization) {

        if (Objects.isNull(pizzaCustomization.getPizza()) || Objects.isNull(pizzaCustomization.getPizza().getId()))
            throw new BusinessException("Pizza is mandatory");

        final var pizza = pizzaService.getPizzaById(pizzaCustomization.getPizza().getId());

        pizzaCustomization.setPizza(pizza);

        final Set<Topping> toppings = new HashSet<>();

        pizzaCustomization.getToppings()
                .forEach(topping -> {
                    toppings.add(toppingService.getIngredientById(topping.getId()));
                });

        pizzaCustomization.setToppings(toppings);

        if (Objects.isNull(pizzaCustomization.getCrust()) || Objects.isNull(pizzaCustomization.getCrust().getId()))
            throw new BusinessException("Crust type is mandatory");

        final var crust = parameterService.getParameterById(pizzaCustomization.getCrust().getId());

        if (Objects.isNull(pizzaCustomization.getSize()) || Objects.isNull(pizzaCustomization.getSize().getId()))
            throw new BusinessException("Size type is mandatory");

        final var size = parameterService.getParameterById(pizzaCustomization.getSize().getId());

        pizzaCustomization.setSize(size);
        pizzaCustomization.setCrust(crust);

        return pizzaCustomizationRepository.save(pizzaCustomization);
    }

    @Override
    public PizzaCustomization findByPizzaId(Long idPizza) {
        return pizzaCustomizationRepository.findByPizzaId(idPizza);
    }
}
