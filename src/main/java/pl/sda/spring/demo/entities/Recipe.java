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
}

