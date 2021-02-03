package pl.sda.spring.demo.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
public class RecipeDto {

    private static final int MIN_SIZE_NAME = 2;
    private static final int MAX_SIZE_NAME = 40;

    private static final int MIN_SIZE_DESCRIPTION = 10;
    private static final int MAX_SIZE_DESCRIPTION = 100;

    private static final int MAX_CALORIES = 20000;

    private static final int MIN_RANGE_PREPARATION = 15;
    private static final int MAX_RANGE_PREPARATION = 240;

    private static final int MIN_FED_PEOPLE = 1;
    private static final int MAX_FED_PEOPLE = 10;


    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = MIN_SIZE_NAME, max = MAX_SIZE_NAME,
            message = "Nazwa powinna zawierać co najmniej " + MIN_SIZE_NAME + " znaki i nie więcej " + MAX_SIZE_NAME + ".")
    private final String name;


    @NotEmpty
    @NotNull
    @Size(min = MIN_SIZE_DESCRIPTION, max = MAX_SIZE_DESCRIPTION)
    private final String description;

    @Max(MAX_CALORIES)
    private final int calories;

    @Range(min = MIN_RANGE_PREPARATION, max = MAX_RANGE_PREPARATION)
    private final int preparationTimeInMin;

    @Range(min = MIN_FED_PEOPLE, max = MAX_FED_PEOPLE)
    private final int forHowManyPeople;

}
