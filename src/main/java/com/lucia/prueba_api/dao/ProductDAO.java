package com.lucia.prueba_api.dao;

import com.lucia.prueba_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Long> {
}
