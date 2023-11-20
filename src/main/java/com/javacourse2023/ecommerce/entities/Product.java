package com.javacourse2023.ecommerce.entities;

import com.javacourse2023.ecommerce.entities.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product extends BaseEntity {
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
}
