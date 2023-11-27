package com.javacourse2023.ecommerce.basket;

import com.javacourse2023.ecommerce.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Optional<Basket> getByUserId(long userId);
}