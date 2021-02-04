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

    @Size(min = MIN_SIZE_NAME,max = MAX_SIZE_NAME,
            message = "Nazwa powinna zawierać co najmniej " + MIN_SIZE_NAME + " znaki i nie więcej " + MAX_SIZE_NAME + ".")
    private String name;

    private String type;


    @Min(MIN_PRICE)
    private float price;

}
