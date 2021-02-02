package pl.sda.spring.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.spring.demo.mappers.RecipeMapper;
import pl.sda.spring.demo.models.recipe.Recipe;
import pl.sda.spring.demo.models.recipe.RecipeDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class RecipeRepository {

    private final RecipeRepositoryInterface recipeRepositoryInterface;

    @Autowired
    public RecipeRepository(RecipeRepositoryInterface recipeRepository) {
        this.recipeRepositoryInterface = recipeRepository;
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepositoryInterface.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepositoryInterface.findAll();
    }

    public Optional<Recipe> getRecipeById(int id) {
        return recipeRepositoryInterface.findById(id);
    }

    public Optional<Recipe> deleteRecipeWtihId(int id) {
        Optional<Recipe> recipe = getRecipeById(id);
        recipeRepositoryInterface.deleteById(id);
        return recipe;
    }

    public Recipe updateRecipeWithId(int id, RecipeDto recipeDto) {
        deleteRecipeWtihId(id).orElseThrow(NoSuchElementException::new);
        return addRecipe(RecipeMapper.recipeMapper(recipeDto));
    }
}
