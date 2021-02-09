package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.entities.ProductEntity;
import pl.sda.spring.demo.entitiesDto.ProductDto;
import pl.sda.spring.demo.mappers.ProductMapper;
import pl.sda.spring.demo.repositories.product.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity addProduct(ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.productMapper(productDto);

        return productRepository.addProduct(productEntity);
    }

    public ProductEntity getProductById(int id) {
        return productRepository.getProductById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public ProductEntity deleteProductWithId(int id) {
        return productRepository.deleteProductWithId(id).orElseThrow(NoSuchElementException::new);
    }

    public ProductEntity updateProductWithId(int id, ProductDto productDto) {
        return productRepository.updateProductWithId(id, productDto);
    }
}
