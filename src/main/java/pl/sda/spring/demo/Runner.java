package pl.sda.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.spring.demo.controllers.RecipeController;
import pl.sda.spring.demo.models.recipe.RecipeDto;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    RecipeController recipeController;

    @Override
    public void run(String... args) throws Exception {



        RecipeDto pierozki = new RecipeDto("Pierozki", "Pyszne pierozki od mamusi", 650, 15, 1,null);
        RecipeDto zupaPomidorowa = new RecipeDto("Zupa pomidorowa", "Pyszne zupa pomidorowa od mamusi", 350, 20, 1,null);
        RecipeDto makaron = new RecipeDto("Makaron z kurczakiem", "Pyszny makaron z kurczakiem", 1200, 75, 4,null);

        recipeController.addRecipe(pierozki);
        recipeController.addRecipe(zupaPomidorowa);
        recipeController.addRecipe(makaron);

    }
}
