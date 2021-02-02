package pl.sda.spring.demo.mappers;

import pl.sda.spring.demo.models.recipe.Recipe;
import pl.sda.spring.demo.models.recipe.RecipeDto;

public class RecipeMapper {

    public static Recipe recipeMapper(RecipeDto recipeDto){
        Recipe recipe = Recipe.builder()
                .name(recipeDto.getName())
                .description(recipeDto.getDescription())
                .calories(recipeDto.getCalories())
                .forHowManyPeople(recipeDto.getForHowManyPeople())
                .forHowManyPeople(recipeDto.getForHowManyPeople())
                .build();
        return recipe;
    }


}
