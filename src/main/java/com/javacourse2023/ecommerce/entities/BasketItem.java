package com.javacourse2023.ecommerce.entities;

import com.javacourse2023.ecommerce.entities.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class BasketItem extends BaseEntity {
    @ManyToOne
    private Product product;
    private int lineOrder;
    @ManyToOne
    private Basket basket;
}
