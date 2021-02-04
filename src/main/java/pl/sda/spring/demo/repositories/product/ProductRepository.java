package pl.sda.spring.demo.repositories.product;

import org.springframework.stereotype.Repository;
import pl.sda.spring.demo.entities.ProductEntity;
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

    public ProductEntity addProduct(ProductEntity productEntity) {
        return productRepositoryInterface.save(productEntity);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepositoryInterface.findAll();
    }

    public Optional<ProductEntity> getProductById(int id) {
        return productRepositoryInterface.findById(id);
    }

    public Optional<ProductEntity> deleteProductWithId(int id) {
        Optional<ProductEntity> product = getProductById(id);
        productRepositoryInterface.deleteById(id);
        return product;
    }

    public ProductEntity updateProductWithId(int id, ProductDto productDto) {
        deleteProductWithId(id).orElseThrow(NoSuchElementException::new);
        return addProduct(ProductMapper.productMapper(productDto));
    }
}
