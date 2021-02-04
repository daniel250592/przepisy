package pl.sda.spring.demo.repositories.recipeToService;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.entities.RecipesToProductsEntity;

public interface RecipeToProductInterface extends JpaRepository<RecipesToProductsEntity,Integer> {
}
