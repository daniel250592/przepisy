package pl.sda.spring.demo.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.entities.Product;

public interface ProductRepositoryInterface extends JpaRepository<Product,Integer> {
}
