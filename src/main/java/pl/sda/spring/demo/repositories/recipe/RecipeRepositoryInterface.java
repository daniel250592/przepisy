package pl.sda.spring.demo.repositories.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.entities.Recipe;

public interface RecipeRepositoryInterface  extends JpaRepository<Recipe,Integer> {

}