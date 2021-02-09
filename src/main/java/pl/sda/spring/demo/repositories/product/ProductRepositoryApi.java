package pl.sda.spring.demo.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.entities.ProductEntity;

public interface ProductRepositoryApi extends JpaRepository<ProductEntity, Integer> {
}
