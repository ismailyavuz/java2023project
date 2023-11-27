package com.javacourse2023.ecommerce.entities;

import com.javacourse2023.ecommerce.entities.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Basket extends BaseEntity {
    @OneToMany(mappedBy = "basket")
    private List<BasketItem> items;
    @OneToOne
    private User user;

}
