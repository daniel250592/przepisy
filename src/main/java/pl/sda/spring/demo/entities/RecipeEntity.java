package pl.sda.spring.demo.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String description;

    private int calories;

    private int preparationTimeInMin;

    private int forHowManyPeople;
}

