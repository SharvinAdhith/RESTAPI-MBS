package com.example.mbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.example.mbs.entity.User;
import com.example.mbs.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getur")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/postur")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/updateur/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
       return userService.updateUser(id, user);
    }

    @GetMapping("/getur/{name}")
    public User getByUserName(@PathVariable String name){
        return userService.getByUserName(name);
    }
    
    
    @GetMapping("/getur/{id}")
    public User getByUserId(@PathVariable int id){
        return userService.getByUserId(id);
    }

    @DeleteMapping("/deleteur/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping("/pageur")
    public Page<User> getUserByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
        return userService.getUserByPage(page, size);
    }
}
