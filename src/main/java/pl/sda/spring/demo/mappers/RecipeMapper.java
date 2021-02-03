package pl.sda.spring.demo.mappers;

import pl.sda.spring.demo.entities.Recipe;
import pl.sda.spring.demo.entitiesDto.RecipeDto;

public class RecipeMapper {

    public static Recipe recipeMapper(RecipeDto recipeDto) {

        return Recipe.builder()
                .name(recipeDto.getName())
                .description(recipeDto.getDescription())
                .calories(recipeDto.getCalories())
                .forHowManyPeople(recipeDto.getForHowManyPeople())
                .forHowManyPeople(recipeDto.getForHowManyPeople())
                .build();
    }


}
