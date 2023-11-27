package com.javacourse2023.ecommerce.basket;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class BasketResponse {

    private BigDecimal total;
    private List<BasketItemResponseDto> items;

}
