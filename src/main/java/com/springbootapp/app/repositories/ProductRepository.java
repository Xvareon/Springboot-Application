package com.springbootapp.app.repositories;

import com.springbootapp.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String url);

    @Query("SELECT p from Product p WHERE p.name LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    List<Product> findAllByOrderById();
}
