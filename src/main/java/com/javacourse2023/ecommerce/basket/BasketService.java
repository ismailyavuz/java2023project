package com.javacourse2023.ecommerce.basket;

import com.javacourse2023.ecommerce.entities.Basket;
import com.javacourse2023.ecommerce.entities.BasketItem;
import com.javacourse2023.ecommerce.entities.User;
import com.javacourse2023.ecommerce.security.ExampleAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository repository;
    private final ExampleAuthService authService;

    public BasketResponse getBasket() {
        Basket basket = getOrCreateBasket();
        return convertToResponse(basket);
    }

    private Basket getOrCreateBasket() {
        Optional<Basket> basketOpt = repository.getByUserId(authService.getCurrentUserId());
        return basketOpt.orElseGet(createBasket());
    }

    private Supplier<Basket> createBasket() {
        User refUser = User.builder()
                .id(authService.getCurrentUserId())
                .build();
        return () -> repository.save(Basket.builder()
                .user(refUser)
                .build());
    }

    private BasketResponse convertToResponse(Basket basket) {
        List<BasketItemResponseDto> items = basket.getItems().stream()
                .map(this::convertToItemDto)
                .toList();

        return BasketResponse.builder()
                .total(items.stream()
                        .map(BasketItemResponseDto::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .items(items)
                .build();
    }

    private BasketItemResponseDto convertToItemDto(BasketItem basketItem) {
        return BasketItemResponseDto.builder()
                .price(basketItem.getProduct().getPrice())
                .lineNo(basketItem.getLineOrder())
                .productId(basketItem.getProduct().getId())
                .quantity(basketItem.getQuantity())
                .build();
    }

    public BasketResponse save(BasketRequest request) {
        Basket basket = getOrCreateBasket();
        //basket.setItems();
        BasketResponse response = convertToResponse(basket);
        if (response.getTotal().compareTo(request.getTotal()) != 0) {
            throw new RuntimeException("Total is not correct");
        }
        repository.save(basket);
        return response;
    }
}
