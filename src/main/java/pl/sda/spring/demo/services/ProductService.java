package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.spring.demo.repositories.product.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
