package org.example.task5.controller;

import org.example.task5.dto.Product;
import org.example.task5.dto.UserProducts;
import org.example.task5.dto.UserProductsInfo;
import org.example.task5.service.UserProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userproducts")
public class UserProductsController {
    private final UserProductsService userProductsService;

    @Autowired
    public UserProductsController(UserProductsService userProductsService) {
        this.userProductsService = userProductsService;
    }

    @GetMapping(value = "/byid/{value}")
    public List<Product> getByUsername(@PathVariable long value){
        return userProductsService.getAllUserProducts(value);
    }

    @GetMapping("/allinfo")
    public List<UserProductsInfo> getAll(){
        return userProductsService.getAll();
    }

    @PostMapping("/create")
    public String createUserProducts(@RequestBody UserProducts userproducts){
        try{
            userProductsService.addUserProducts(userproducts.getUserId(), userproducts.getProductId());
            return "Create successfully";
        }
        catch (Exception e) {
            return "Create unsuccessfully " + e.getMessage();
        }
    }

}
