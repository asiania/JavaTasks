package org.example.task5.controller;

import org.example.task5.dto.Product;
import org.example.task5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/byid/{value}")
    public Product getById(@PathVariable long value){
        return productService.getById(value);
    }

    @GetMapping("/allproducts")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product){
        try{
            productService.addProduct(product.getAccnum(), product.getBalance(), product.getType());
            return "Create successfully";
        }
        catch (Exception e) {
            return "Create unsuccessfully " + e.getMessage();
        }
    }

    @DeleteMapping(value = "/delete/{value}")
    public String deleteProduct(@PathVariable long value){
        try{
            productService.delete(value);
            return "Delete successfully";
        }
        catch (Exception e) {
            return "Delete unsuccessfully " + e.getMessage();
        }

    }
}
