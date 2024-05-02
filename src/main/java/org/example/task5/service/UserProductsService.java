package org.example.task5.service;

import org.example.task5.dto.Product;
import org.example.task5.dto.UserProductsInfo;
import org.example.task5.repository.UserProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserProductsService {

    private final UserProductsRepository userProductsRepository;

    @Autowired
    public UserProductsService(UserProductsRepository userProductsRepository) {
        this.userProductsRepository = userProductsRepository;
    }

    public void addUserProducts(long userId, long productId) {
        userProductsRepository.addUserProducts(userId, productId);
    }

    public List<Product> getAllUserProducts(long userId) {
        return userProductsRepository.getAllUserProducts(userId);
    }

    public List<UserProductsInfo> getAll() {
        return userProductsRepository.getAll();
    }
}
