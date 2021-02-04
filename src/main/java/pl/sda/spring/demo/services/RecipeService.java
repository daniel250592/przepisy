package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.entities.Recipe;
import pl.sda.spring.demo.entitiesDto.RecipeDto;
import pl.sda.spring.demo.mappers.RecipeMapper;
import pl.sda.spring.demo.repositories.recipe.RecipeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe addRecipe(RecipeDto recipeDto) {
        Recipe recipe = RecipeMapper.recipeMapper(recipeDto);

        return recipeRepository.addRecipe(recipe);
    }

    public Recipe getRecipeById(int id) {
        return recipeRepository.getRecipeById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public Recipe deleteRecipeWithId(int id) {
        return recipeRepository.deleteRecipeWithId(id).orElseThrow(NoSuchElementException::new);
    }

    public Recipe updateRecipeWithId(int id, RecipeDto recipeDto) {
        return recipeRepository.updateRecipeWithId(id, recipeDto);
    }
}
