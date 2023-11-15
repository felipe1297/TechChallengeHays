package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.ToppingService;
import com.hays.hays_order_ms.application.port.out.repository.ToppingRepository;
import com.hays.hays_order_ms.domain.model.Topping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ToppingServiceImpl implements ToppingService {

    private final ToppingRepository toppingRepository;

    @Transactional
    @Override
    public Topping creatIngredient(Topping topping) {
        return toppingRepository.save(topping);
    }

    @Override
    public Topping getIngredientById(Long id) {
        return toppingRepository.findById(id);
    }

    @Override
    public List<Topping> getXIngredientByName(String name, Integer number) {
        return toppingRepository.findByNameTop(name, number);
    }

    @Override
    public List<Topping> getAll() {
        return toppingRepository.findAll();
    }
}
