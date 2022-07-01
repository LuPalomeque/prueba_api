package com.lucia.prueba_api.controller;

import com.lucia.prueba_api.dao.ProductDAO;
import com.lucia.prueba_api.entities.Product;
import com.lucia.prueba_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductsController {

    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping(value = "{productId}")  //    /products/{productId}
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
        Optional<Product> optionalProduct = productService.getProductById(productId);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> optionalProduct = productService.getProductById(product.getId());
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(productService.updateProduct(product, optionalProduct.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
