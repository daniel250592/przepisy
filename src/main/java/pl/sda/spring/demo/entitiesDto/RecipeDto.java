package pl.sda.spring.demo.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
@Builder
public class RecipeDto {

    private final Integer id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 40,
            message = "Nazwa powinna zawierać co najmniej 2 znaki i nie więcej nic 40.")
    private final String name;

    @NotEmpty
    @NotNull
    @Size(min = 10, max = 100)
    private final String description;

    @Max(20000)
    private final int calories;

    @Range(min = 15, max = 240)
    private final int preparationTimeInMin;

    @Range(min = 1, max = 10)
    private final int forHowManyPeople;

}
