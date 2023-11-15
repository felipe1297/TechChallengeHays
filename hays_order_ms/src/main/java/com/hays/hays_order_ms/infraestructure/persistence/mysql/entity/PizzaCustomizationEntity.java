package com.hays.hays_order_ms.infraestructure.persistence.mysql.entity;

import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static com.hays.hays_order_ms.domain.utilities.Constants.CRUST;
import static com.hays.hays_order_ms.domain.utilities.Constants.SIZE;

@Data
@Getter
@Setter
@Entity
@Table(name = "pizza_customization")
public class PizzaCustomizationEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private PizzaEntity pizza;
    @ManyToMany
    @JoinTable(
            name = "pizza_customization_toppings",
            joinColumns = @JoinColumn(name = "customization_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private Set<ToppingEntity> toppings;
    @ManyToOne
    @JoinColumn(name = "size_id")
    private ParameterEntity size;
    @ManyToOne
    @JoinColumn(name = "crust_id")
    private ParameterEntity crust;
    @Column(name = "notes")
    private String notes;

    public void setCrust(ParameterEntity crust) {
        if (!CRUST.equalsIgnoreCase(crust.getType())) {
            throw new BusinessException("Invalid type for crust");
        }
        this.crust = crust;
    }

    public void setSize(ParameterEntity size) {
        if (!SIZE.equalsIgnoreCase(size.getType())) {
            throw new BusinessException("Invalid type for size");
        }
        this.size = size;
    }

}
