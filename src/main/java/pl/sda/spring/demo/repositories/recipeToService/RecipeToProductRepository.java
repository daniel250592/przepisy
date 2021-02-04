package pl.sda.spring.demo.repositories.recipeToService;

import org.springframework.stereotype.Repository;
import pl.sda.spring.demo.entities.RecipesToProductsEntity;
import pl.sda.spring.demo.repositories.recipe.RecipeRepositoryInterface;
import pl.sda.spring.demo.services.RecipeToProductService;

@Repository
public class RecipeToProductRepository {

    private final RecipeToProductInterface recipeToProductInterface;

    public RecipeToProductRepository(RecipeToProductInterface recipeToProductInterface) {
        this.recipeToProductInterface = recipeToProductInterface;
    }

    public RecipesToProductsEntity addProductToRecipe(RecipesToProductsEntity recipesToProductsEntity){
       return recipeToProductInterface.save(recipesToProductsEntity);
    }
}
