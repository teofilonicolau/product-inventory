package com.agilstore.productinventory.service;


import com.agilstore.productinventory.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JsonPersistenceService {

    private static final String FILE_PATH = "products.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void saveProducts(List<Product> products) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> loadProducts() {
        try {
            return objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}

