package pl.sda.spring.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Product_to_recipe")
public class PairEntity<T extends RecipeEntity, R extends ProductEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = RecipeEntity.class)
    private T recipeEntity;

    @ManyToOne(targetEntity = ProductEntity.class)
    private R productEntity;
}
