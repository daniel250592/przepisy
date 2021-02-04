package pl.sda.spring.demo.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.entities.ProductEntity;

public interface ProductRepositoryInterface extends JpaRepository<ProductEntity,Integer> {
}
