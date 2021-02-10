package pl.sda.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.demo.entities.PairEntity;
import pl.sda.spring.demo.entities.ProductEntity;
import pl.sda.spring.demo.entities.RecipeEntity;
import pl.sda.spring.demo.repositories.pair.PairRepository;

import java.util.List;

@Service
public class PairService {

    private final PairRepository pairRepository;

    private final ProductService productService;


    @Autowired
    public PairService(PairRepository pairRepository, ProductService productService) {
        this.pairRepository = pairRepository;
        this.productService = productService;

    }

    public PairEntity addProductToRecipe(int productId, RecipeEntity recipeEntity) {
        ProductEntity product = productService.getProductById(productId);


        var pairEntity = new PairEntity<ProductEntity, RecipeEntity>();
        pairEntity.setProductEntity(product);
        pairEntity.setRecipeEntity(recipeEntity);

        return pairRepository.addProductToRecipe(pairEntity);

    }


    public List<Integer> getProductsFromRecipeWithId(int id) {
        return pairRepository.getProductsFromRecipeWithId(id);

    }
}
