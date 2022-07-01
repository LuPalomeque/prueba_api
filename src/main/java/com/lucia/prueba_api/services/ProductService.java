package com.lucia.prueba_api.services;

import com.lucia.prueba_api.dao.ProductDAO;
import com.lucia.prueba_api.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public List<Product> getProducts() {
        return productDAO.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productDAO.findById(id);
    }

    public Product createProduct(Product product) {
        return productDAO.save(product);
    }

    public void deleteProduct(Long productId) {
        productDAO.deleteById(productId);
    }

    public Product updateProduct(Product productWithChanges, Product productToChange) {
        productToChange.setName(productWithChanges.getName());
        return productDAO.save(productToChange);
    }
}
