package pl.sda.spring.demo.repositories.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.entities.RecipeEntity;

public interface RecipeRepositoryApi extends JpaRepository<RecipeEntity, Integer> {

}
