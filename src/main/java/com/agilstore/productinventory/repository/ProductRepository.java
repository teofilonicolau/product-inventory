package com.agilstore.productinventory.repository;


import com.agilstore.productinventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
    List<Product> findByCategory(String category);
    List<Product> findAllByOrderByNameAsc();
    List<Product> findAllByOrderByNameDesc();
    List<Product> findAllByOrderByQuantityAsc();
    List<Product> findAllByOrderByQuantityDesc();
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
}



