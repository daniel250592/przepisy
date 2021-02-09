package pl.sda.spring.demo.mappers;

import pl.sda.spring.demo.entities.ProductEntity;
import pl.sda.spring.demo.entitiesDto.ProductDto;

public class ProductMapper {

    public static ProductEntity productMapper(ProductDto productDto) {

        return ProductEntity.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .type(productDto.getType())
                .build();
    }

    public static ProductDto productMapper(ProductEntity productEntity) {
        return ProductDto.builder()
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .type(productEntity.getType())
                .build();
    }
}
