package pl.sda.spring.demo.models.product;


import lombok.*;
import pl.sda.spring.demo.models.recipe.Recipe;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class Product {

    @Id
    private int id;

    @Column(unique = true)
    private String name;

    private String type;

    @Min(1)
    private float price;

    @ManyToMany
    private Set<Recipe> recipes;
}
