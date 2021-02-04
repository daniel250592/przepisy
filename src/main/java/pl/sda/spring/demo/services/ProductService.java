package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.entities.Product;
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

    public Product addProduct(ProductDto productDto) {
        Product product = ProductMapper.productMapper(productDto);

        return productRepository.addProduct(product);
    }

    public Product getProductById(int id){
        return productRepository.getProductById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Product deleteProductWithId(int id){
        return productRepository.deleteProductWithId(id).orElseThrow(NoSuchElementException::new);
    }

    public Product updateProductWithId(int id,ProductDto productDto){
        return productRepository.updateProductWithId(id,productDto);
    }
}
