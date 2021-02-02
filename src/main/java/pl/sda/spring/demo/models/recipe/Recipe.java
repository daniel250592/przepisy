package pl.sda.spring.demo.models.recipe;

import lombok.*;
import pl.sda.spring.demo.models.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, length = 40)
    private String name;

    @Column(length = 100)
    private String description;

    private int calories;

    private int preparationTimeInMin;

    private int forHowManyPeople;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Product> products;

}

