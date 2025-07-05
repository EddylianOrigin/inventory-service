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

    //sales team : update the stock of a product in (IS)
    public Product updateStock(int id, int quantity) {
        Product existingProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        existingProduct.setStock(quantity);
        return repository.save(existingProduct);
    }

    //warehouse : receive new shipment
    public Product receiveNewShipment(int id, int quantity) {
        Product existingProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        existingProduct.setStock(existingProduct.getStock() + quantity);
        return repository.save(existingProduct);
    }
}
