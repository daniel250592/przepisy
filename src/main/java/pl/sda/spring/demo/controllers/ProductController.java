package pl.sda.spring.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.demo.entities.ProductEntity;
import pl.sda.spring.demo.entitiesDto.ProductDto;
import pl.sda.spring.demo.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new-product")
    public ProductEntity addProduct(@Valid @RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @GetMapping("/all-products")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product{id}")
    public ProductEntity getRecipeById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/product{id}")
    public ProductEntity updateProductById(@PathVariable int id, @Valid @RequestBody ProductDto productDto) {
        return productService.updateProductWithId(id, productDto);
    }

    @DeleteMapping("/product{id}")
    public ProductEntity deleteProductById(@PathVariable int id) {
        return productService.deleteProductWithId(id);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleNoSuchElementException(RuntimeException runtimeException) {
        return new ResponseEntity<>("Ogólny wyjątek", HttpStatus.BAD_REQUEST);
    }
}
