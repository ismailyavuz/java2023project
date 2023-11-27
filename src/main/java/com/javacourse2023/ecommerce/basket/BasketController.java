package com.javacourse2023.ecommerce.basket;

import com.javacourse2023.ecommerce.entities.Basket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;

    @GetMapping
    public BasketResponse get() {
        return service.getBasket();
    }

    @PostMapping
    public BasketResponse save(@RequestBody BasketRequest basket) {
        return service.save(basket);
    }

    @DeleteMapping
    public Basket delete(@PathVariable Long id) {
        return null;
    }

}
