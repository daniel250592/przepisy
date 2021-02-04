package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.entities.RecipeEntity;
import pl.sda.spring.demo.entities.RecipesToProductsEntity;
import pl.sda.spring.demo.entitiesDto.RecipeDto;
import pl.sda.spring.demo.mappers.RecipeMapper;
import pl.sda.spring.demo.repositories.recipe.RecipeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToProductService recipeToProductService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeToProductService recipeToProductService) {
        this.recipeRepository = recipeRepository;
        this.recipeToProductService = recipeToProductService;
    }

    public RecipeEntity addRecipe(RecipeDto recipeDto) {
        RecipeEntity recipeEntity = RecipeMapper.recipeMapper(recipeDto);

        return recipeRepository.addRecipe(recipeEntity);
    }

    public RecipeEntity getRecipeById(int id) {
        return recipeRepository.getRecipeById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public RecipeEntity deleteRecipeWithId(int id) {
        return recipeRepository.deleteRecipeWithId(id).orElseThrow(NoSuchElementException::new);
    }

    public RecipeEntity updateRecipeWithId(int id, RecipeDto recipeDto) {
        return recipeRepository.updateRecipeWithId(id, recipeDto);
    }

    public RecipesToProductsEntity addProductToRecipe(int productid, int recipeid) {
        RecipeEntity recipeEntity = recipeRepository.getRecipeById(recipeid).orElseThrow(NoSuchElementException::new);
        return recipeToProductService.addProductToRecipe(productid, recipeEntity);

    }
}
