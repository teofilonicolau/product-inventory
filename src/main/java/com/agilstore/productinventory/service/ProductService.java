package com.agilstore.productinventory.service;


import com.agilstore.productinventory.model.Product;
import com.agilstore.productinventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JsonPersistenceService jsonPersistenceService;

    @PostConstruct
    public void init() {
        List<Product> products = jsonPersistenceService.loadProducts();
        if (!products.isEmpty()) {
            productRepository.saveAll(products);
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        saveAllProducts();
        return savedProduct;
    }

    public Optional<Product> updateProduct(Long id, Product productDetails) {
        Optional<Product> updatedProduct = productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setCategory(productDetails.getCategory());
            product.setQuantity(productDetails.getQuantity());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        });
        saveAllProducts();
        return updatedProduct;
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            saveAllProducts();
            return true;
        } else {
            return false;
        }
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> sortProducts(String sortBy, String order) {
        switch (sortBy) {
            case "name":
                return order.equals("asc") ? productRepository.findAllByOrderByNameAsc() : productRepository.findAllByOrderByNameDesc();
            case "quantity":
                return order.equals("asc") ? productRepository.findAllByOrderByQuantityAsc() : productRepository.findAllByOrderByQuantityDesc();
            case "price":
                return order.equals("asc") ? productRepository.findAllByOrderByPriceAsc() : productRepository.findAllByOrderByPriceDesc();
            default:
                return productRepository.findAll();
        }
    }

    private void saveAllProducts() {
        List<Product> products = productRepository.findAll();
        jsonPersistenceService.saveProducts(products);
    }
}

