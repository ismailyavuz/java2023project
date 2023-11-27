package com.javacourse2023.ecommerce.basket;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
public class BasketItemResponseDto extends BasketItemRequestDto {

    private BigDecimal price;

}
