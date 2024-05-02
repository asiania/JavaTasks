package org.example.task5.service;

import org.example.task5.dto.User;
import org.example.task5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class  UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String username) {
        userRepository.addUser(username);
    }

    public void delete(long id) {
        userRepository.delete(id);
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
