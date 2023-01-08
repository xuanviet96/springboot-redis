package com.example.springbootredis.controller;

import com.example.springbootredis.entity.Product;
import com.example.springbootredis.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@EnableCaching
public class RedisController {
    @Autowired
    private ProductDAO productDAO;
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productDAO.save(product);
    }
    @GetMapping
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }
    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product", unless = "#result.name < 2100")
    public Product findProductById(@PathVariable Integer id) {
        return productDAO.findById(id);
    }
    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "Product")
    public String deleteProductById(@PathVariable Integer id) {
        return productDAO.delete(id);
    }


}
