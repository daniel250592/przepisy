package pl.sda.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.demo.entities.Recipe;
import pl.sda.spring.demo.entitiesDto.RecipeDto;
import pl.sda.spring.demo.services.RecipeService;

import javax.validation.Valid;
import java.sql.SQLException;
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
    public Recipe addRecipe(@Valid @RequestBody RecipeDto recipeDto) {
        return recipeService.addRecipe(recipeDto);
    }


    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping({"/recipe{id}"})
    public Recipe getRecipeById(@PathVariable int id) {
        return recipeService.getRecipeById(id);
    }

    @PutMapping("recipe{id}")
    public Recipe updateRecipeById(@PathVariable int id, @Valid @RequestBody RecipeDto recipeDto) {
        return recipeService.updateRecipeWithId(id, recipeDto);
    }

    @DeleteMapping("/recipe{id}")
    public Recipe deleteRecipeById(@PathVariable int id) {
        return recipeService.deleterecipeWithId(id);
    }


//    @ExceptionHandler(value = RuntimeException.class)
//    public ResponseEntity<Object> handleNoSuchElementException(RuntimeException exception) {
//        return new ResponseEntity<>("ogólny wyjatek", HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<Object> handleNoSuchElementException(SQLException exception) {
        return new ResponseEntity<>("Wyjątek z bazy danych", HttpStatus.BAD_REQUEST);
    }
}

