package pl.sda.spring.demo.mappers;

import pl.sda.spring.demo.entities.Product;
import pl.sda.spring.demo.entitiesDto.ProductDto;

public class ProductMapper {

    public static Product productMapper(ProductDto productDto) {

        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .type(productDto.getType())
                .build();
    }

    public static ProductDto productMapper(Product product){
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .type(product.getType())
                .build();
    }
}
