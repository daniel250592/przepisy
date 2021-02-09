package pl.sda.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.spring.demo.controllers.RecipeController;
import pl.sda.spring.demo.entitiesDto.RecipeDto;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    RecipeController recipeController;

    @Override
    public void run(String... args) {


        RecipeDto pierozki = new RecipeDto(null,"Pierozki", "Pyszne pierozki od mamusi", 650, 15, 1);
        RecipeDto zupaPomidorowa = new RecipeDto(null,"Zupa pomidorowa", "Pyszne zupa pomidorowa od mamusi", 350, 20, 1);
        RecipeDto makaron = new RecipeDto(null,"Makaron z kurczakiem", "Pyszny makaron z kurczakiem", 1200, 75, 4);

        recipeController.addRecipe(pierozki);
        recipeController.addRecipe(zupaPomidorowa);
        recipeController.addRecipe(makaron);

    }
}
