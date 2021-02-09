package pl.sda.spring.demo.repositories.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.spring.demo.entities.RecipeEntity;
import pl.sda.spring.demo.entitiesDto.RecipeDto;
import pl.sda.spring.demo.mappers.RecipeMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class RecipeRepository {

    private final RecipeRepositoryApi recipeRepositoryApi;

    @Autowired
    public RecipeRepository(RecipeRepositoryApi recipeRepository) {
        this.recipeRepositoryApi = recipeRepository;
    }

    public RecipeEntity addRecipe(RecipeEntity recipeEntity) {
        return recipeRepositoryApi.save(recipeEntity);
    }

    public List<RecipeEntity> getAllRecipes() {
        return recipeRepositoryApi.findAll();
    }

    public Optional<RecipeEntity> getRecipeById(int id) {
        return recipeRepositoryApi.findById(id);
    }

    public Optional<RecipeEntity> deleteRecipeWithId(int id) {
        Optional<RecipeEntity> recipe = getRecipeById(id);
        recipeRepositoryApi.deleteById(id);
        return recipe;
    }

    public RecipeEntity updateRecipeWithId(int id, RecipeDto recipeDto) {
        deleteRecipeWithId(id).orElseThrow(NoSuchElementException::new);
        return addRecipe(RecipeMapper.recipeMapper(recipeDto));
    }
}
