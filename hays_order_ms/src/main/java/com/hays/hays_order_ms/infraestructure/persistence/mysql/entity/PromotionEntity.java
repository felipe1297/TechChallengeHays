package com.hays.hays_order_ms.infraestructure.persistence.mysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String code;
    @Column(name = "percentage")
    private Integer percentage;
    @Column(name = "available")
    private Boolean available;
    @Column(name = "beginDate")
    private Date beginDate;
    @Column(name = "endDate")
    private Date endDate;
}
