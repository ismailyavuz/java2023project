package com.javacourse2023.ecommerce.product;

import com.javacourse2023.ecommerce.entities.Product;
import com.javacourse2023.ecommerce.exception.ECommerceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ECommerceException(""));
    }

    public Product save(Product product){
        return repository.save(product);
    }

    public Product delete(Long id){
        Product product = repository.findById(id).get();
        repository.deleteById(id);
        return product;
    }

    public Product update(Long id, Product product){
        Product p = repository.findById(id).get();
        p.setName((product.getName()));
        p.setDescription(product.getDescription());
        p.setStock(product.getStock());
        p.setPrice(product.getPrice());
        return repository.save(p);
    }
}
