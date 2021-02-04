package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.entities.ProductEntity;
import pl.sda.spring.demo.entities.RecipeEntity;
import pl.sda.spring.demo.entities.RecipesToProductsEntity;
import pl.sda.spring.demo.repositories.recipeToService.RecipeToProductRepository;

@Service
public class RecipeToProductService {

    private final RecipeToProductRepository recipeToProductRepository;

    private final ProductService productService;

    @Autowired
    public RecipeToProductService(RecipeToProductRepository recipeToProductRepository, ProductService productService) {
        this.recipeToProductRepository = recipeToProductRepository;
        this.productService = productService;

    }

    public RecipesToProductsEntity addProductToRecipe(int productId, RecipeEntity recipeEntity) {
        ProductEntity product = productService.getProductById(productId);


        RecipesToProductsEntity recipesToProductsEntity = new RecipesToProductsEntity();
        recipesToProductsEntity.setProductEntity(product);
        recipesToProductsEntity.setRecipeEntity(recipeEntity);

        return recipeToProductRepository.addProductToRecipe(recipesToProductsEntity);

    }
}
