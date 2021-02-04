package pl.sda.spring.demo.entities;

import javax.persistence.*;

@Entity
public class RecipesToProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private Product product;
}
