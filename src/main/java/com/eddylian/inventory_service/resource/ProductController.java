package com.eddylian.inventory_service.resource;

import com.eddylian.inventory_service.entity.Product;
import com.eddylian.inventory_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable String category) {
        return service.getAllProductsByCategory(category);
    }
}
