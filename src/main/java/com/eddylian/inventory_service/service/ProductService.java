package com.eddylian.inventory_service.service;

import com.eddylian.inventory_service.entity.Product;
import com.eddylian.inventory_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public List<Product> getAllProductsByCategory(String category) {
        return repository.findByCategory(category);
    }
}
