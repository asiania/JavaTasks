package org.example.task5.service;

import org.example.task5.dto.Product;
import org.example.task5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int accnum, double balance, String type) {
        productRepository.addProduct(accnum, balance, type);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }

    public Product getById(long id) {
        return productRepository.getById(id);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }
}

