package pl.sda.spring.demo.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Builder
public class ProductDto {

    private static final int MIN_SIZE_NAME = 2;
    private static final int MAX_SIZE_NAME = 40;

    private static final int MIN_PRICE = 0;

    @Size(min = 2, max = 40,
            message = "Nazwa powinna zawierać co najmniej 2 znaki i nie więcej niż 40.")
    private final String name;

    private final String type;


    @Min(0)
    private final float price;

}
