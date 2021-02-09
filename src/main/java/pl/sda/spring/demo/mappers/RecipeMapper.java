package pl.sda.spring.demo.mappers;

import pl.sda.spring.demo.entities.RecipeEntity;
import pl.sda.spring.demo.entitiesDto.RecipeDto;

public class RecipeMapper {

    public static RecipeEntity recipeMapper(RecipeDto recipeDto) {

        return RecipeEntity.builder()
                .name(recipeDto.getName())
                .description(recipeDto.getDescription())
                .calories(recipeDto.getCalories())
                .forHowManyPeople(recipeDto.getForHowManyPeople())
                .forHowManyPeople(recipeDto.getForHowManyPeople())
                .build();
    }

    public static RecipeDto recipeMapper(RecipeEntity recipeEntity) {

        return RecipeDto.builder()
                .id(recipeEntity.getId())
                .name(recipeEntity.getName())
                .description(recipeEntity.getDescription())
                .calories(recipeEntity.getCalories())
                .preparationTimeInMin(recipeEntity.getPreparationTimeInMin())
                .forHowManyPeople(recipeEntity.getForHowManyPeople())
                .build();
    }


}
