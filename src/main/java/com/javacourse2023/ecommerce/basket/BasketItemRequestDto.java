package com.javacourse2023.ecommerce.basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemRequestDto {
    private int lineNo;
    private long productId;
    private int quantity;


}
