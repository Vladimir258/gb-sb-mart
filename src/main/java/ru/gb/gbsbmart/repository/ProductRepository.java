package ru.gb.gbsbmart.repository;

import ru.gb.gbsbmart.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Monitor", 300F),
                new Product(2L, "Keyboard", 5F),
                new Product(3L, "Mouse", 4F),
                new Product(4L, "Processor", 700F),
                new Product(5L, "Memory", 200F)
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }
}
