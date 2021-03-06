package pl.sda.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.demo.entities.PairEntity;
import pl.sda.spring.demo.entities.ProductEntity;
import pl.sda.spring.demo.entities.RecipeEntity;
import pl.sda.spring.demo.entitiesDto.RecipeDto;
import pl.sda.spring.demo.services.RecipeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping("/new-recipe")
    public RecipeDto addRecipe(@Valid @RequestBody RecipeDto recipeDto) {
        return recipeService.addRecipe(recipeDto);
    }


    @GetMapping("/all-recipes")
    public List<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping({"/recipe{id}"})
    public RecipeEntity getRecipeById(@PathVariable int id) {
        return recipeService.getRecipeById(id);
    }

    @PutMapping("/recipe{id}")
    public RecipeEntity updateRecipeById(@PathVariable int id, @Valid @RequestBody RecipeDto recipeDto) {
        return recipeService.updateRecipeWithId(id, recipeDto);
    }

    @DeleteMapping("/recipe{id}")
    public RecipeEntity deleteRecipeById(@PathVariable int id) {
        return recipeService.deleteRecipeWithId(id);
    }

    @PostMapping("/add-product{productid}-to-recipe{recipeid}")
    public PairEntity addProductToRecipe(@PathVariable int productid, @PathVariable int recipeid) {
        return recipeService.addProductToRecipe(productid, recipeid);
    }

    @GetMapping("/products-recipe{id}")
    public List<ProductEntity> getAllProductsFromRecipeWithId(@PathVariable int id) {
        return recipeService.getAllProductsFromRecipeWithId(id);
    }


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleNoSuchElementException(RuntimeException exception) {
        return new ResponseEntity<>("ogólny wyjatek", HttpStatus.BAD_REQUEST);
    }

}

