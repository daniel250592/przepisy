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

    private final ProductRepositoryApi productRepositoryApi;

    public ProductRepository(ProductRepositoryApi productRepositoryApi) {
        this.productRepositoryApi = productRepositoryApi;
    }

    public ProductEntity addProduct(ProductEntity productEntity) {
        return productRepositoryApi.save(productEntity);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepositoryApi.findAll();
    }

    public Optional<ProductEntity> getProductById(int id) {
        return productRepositoryApi.findById(id);
    }

    public Optional<ProductEntity> deleteProductWithId(int id) {
        Optional<ProductEntity> product = getProductById(id);
        productRepositoryApi.deleteById(id);
        return product;
    }

    public ProductEntity updateProductWithId(int id, ProductDto productDto) {
        deleteProductWithId(id).orElseThrow(NoSuchElementException::new);
        return addProduct(ProductMapper.productMapper(productDto));
    }
}
