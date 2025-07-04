package com.eddylian.inventory_service;

import com.eddylian.inventory_service.entity.Product;
import com.eddylian.inventory_service.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @PostConstruct
    public void initDB() {
        List<Product> products = Stream.of(
                new Product("Laptop", "Electronics", 74999.99F, 50),
                new Product("Smartphone", "Electronics", 39999.99F, 100),
                new Product("Office Chair", "Furniture", 7999.99F, 200),
                new Product("Notebook", "Stationery", 99.99F, 500),
                new Product("Desk Lamp", "Furniture", 1999.99F, 150),
                new Product("Water Bottle", "Accessoires", 499.99F, 300)
        ).collect((Collectors.toList()));
        repository.saveAll(products);
    }

}
