package pl.sda.spring.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RecipesToProducts {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private Product product;
}
