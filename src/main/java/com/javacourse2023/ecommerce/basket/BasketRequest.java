package com.javacourse2023.ecommerce.basket;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BasketRequest {
    private BigDecimal total;
    private List<BasketItemRequestDto> items;
}
