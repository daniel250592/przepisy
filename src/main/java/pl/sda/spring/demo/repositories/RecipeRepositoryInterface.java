package pl.sda.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.models.recipe.Recipe;

public interface RecipeRepositoryInterface  extends JpaRepository<Recipe,Integer> {

}
