package pl.sda.spring.demo.models.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.sda.spring.demo.models.recipe.Recipe;

import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Getter
public class ProductDto {

    private static final int MIN_SIZE_NAME = 2;
    private static final int MAX_SIZE_NAME = 40;

    @Size(min = MIN_SIZE_NAME,max = MAX_SIZE_NAME)
    private String name;

    private String type;


    private float price;

    private List<Recipe> recipes;
}
