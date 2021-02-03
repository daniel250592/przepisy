package pl.sda.spring.demo.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    private String type;

    @Min(1)
    private float price;

}
