package com.javacourse2023.ecommerce.product;

import com.javacourse2023.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
