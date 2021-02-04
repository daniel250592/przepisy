package pl.sda.spring.demo.repositories.product;

import org.springframework.stereotype.Repository;
import pl.sda.spring.demo.entities.Product;
import pl.sda.spring.demo.entitiesDto.ProductDto;
import pl.sda.spring.demo.mappers.ProductMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final ProductRepositoryInterface productRepositoryInterface;

    public ProductRepository(ProductRepositoryInterface productRepositoryInterface) {
        this.productRepositoryInterface = productRepositoryInterface;
    }

    public Product addProduct(Product product) {
        return productRepositoryInterface.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepositoryInterface.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepositoryInterface.findById(id);
    }

    public Optional<Product> deleteProductWithId(int id) {
        Optional<Product> product = getProductById(id);
        productRepositoryInterface.deleteById(id);
        return product;
    }

    public Product updateProductWithId(int id, ProductDto productDto) {
        deleteProductWithId(id).orElseThrow(NoSuchElementException::new);
        return addProduct(ProductMapper.productMapper(productDto));
    }
}
