package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.entities.PairEntity;
import pl.sda.spring.demo.entities.ProductEntity;
import pl.sda.spring.demo.entities.RecipeEntity;
import pl.sda.spring.demo.entitiesDto.RecipeDto;
import pl.sda.spring.demo.mappers.RecipeMapper;
import pl.sda.spring.demo.repositories.recipe.RecipeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final PairService pairService;
    private final ProductService productService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, PairService pairService, ProductService productService) {
        this.recipeRepository = recipeRepository;
        this.pairService = pairService;
        this.productService = productService;
    }

    public RecipeDto addRecipe(RecipeDto recipeDto) {
        RecipeEntity recipeEntityWithId = recipeRepository.addRecipe(RecipeMapper.recipeMapper(recipeDto));
        return RecipeMapper.recipeMapper(recipeEntityWithId);
    }

    public RecipeEntity getRecipeById(int id) {
        return recipeRepository.getRecipeById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<RecipeDto> getAllRecipes() {
        return recipeRepository.getAllRecipes().stream().map(RecipeMapper::recipeMapper).collect(Collectors.toList());
    }

    public RecipeEntity deleteRecipeWithId(int id) {
        return recipeRepository.deleteRecipeWithId(id).orElseThrow(NoSuchElementException::new);
    }

    public RecipeEntity updateRecipeWithId(int id, RecipeDto recipeDto) {
        return recipeRepository.updateRecipeWithId(id, recipeDto);
    }

    public PairEntity addProductToRecipe(int productid, int recipeid) {
        RecipeEntity recipeEntity = recipeRepository.getRecipeById(recipeid).orElseThrow(NoSuchElementException::new);
        return pairService.addProductToRecipe(productid, recipeEntity);

    }

    public List<ProductEntity> getAllProductsFromRecipeWithId(int id) {
        return pairService.getProductsFromRecipeWithId(id).stream().map(productService::getProductById).collect(Collectors.toList());
    }
}
