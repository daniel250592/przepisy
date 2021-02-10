package pl.sda.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.spring.demo.controllers.ProductController;
import pl.sda.spring.demo.controllers.RecipeController;
import pl.sda.spring.demo.entitiesDto.ProductDto;
import pl.sda.spring.demo.entitiesDto.RecipeDto;
import pl.sda.spring.demo.services.PairService;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    RecipeController recipeController;

    @Autowired
    ProductController productController;

    @Autowired
    PairService pairService;

    @Override
    public void run(String... args) {


        RecipeDto dumplings = new RecipeDto(null, "Pierozki", "Pyszne pierozki od mamusi", 650, 15, 1);
        RecipeDto tomatoSoup = new RecipeDto(null, "Zupa pomidorowa", "Pyszne zupa pomidorowa od mamusi", 350, 20, 1);
        RecipeDto pasta = new RecipeDto(null, "Makaron z kurczakiem", "Pyszny makaron z kurczakiem", 1200, 75, 4);

        recipeController.addRecipe(dumplings);
        recipeController.addRecipe(tomatoSoup);
        recipeController.addRecipe(pasta);

        ProductDto eggs = new ProductDto("jajka", "jajka", 10);
        ProductDto grain = new ProductDto("zboze", "zboze", 5);

        productController.addProduct(eggs);
        productController.addProduct(grain);

    }
}
