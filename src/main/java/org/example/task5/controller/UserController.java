package org.example.task5.controller;

import org.example.task5.dto.User;
import org.example.task5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/byname/{value}")
    public User getByUsername(@PathVariable String value){
        return userService.getByUsername(value);
    }

    @GetMapping("/allusers")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping(value = "/create/{value}")
    public String createUser(@PathVariable String value){
        try{
            userService.addUser(value);
            return "Create successfully";
        }
        catch (Exception e) {
            return "Create unsuccessfully " + e.getMessage();
        }
    }

    @DeleteMapping(value = "/delete/{value}")
    public String deleteUser(@PathVariable long value){
        try{
            userService.delete(value);
            return "Delete successfully";
        }
        catch (Exception e) {
            return "Delete unsuccessfully " + e.getMessage();
        }

    }


}
