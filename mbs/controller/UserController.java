package com.example.mbs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbs.entity.User;
import com.example.mbs.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/postusers")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
  
    @PutMapping("/updateusers/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
       return userService.updateUser(id, user);
    }

    @DeleteMapping("/deleteusers/by-id/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getusers/by-name/{name}")
    public User getByUserName(@PathVariable String name){
        return userService.getByUserName(name);
    }
    
    @GetMapping("/getusers/{id}")
    public Optional<User> getByUserId(@PathVariable int id){
        return userService.getByUserId(id);
    }

    @GetMapping("/pageusers")
    public Page<User> getUserByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
        return userService.getUserByPage(page, size);
    }

    @GetMapping("/getuserwithalphabet/{letter}")
    public List<User> getUsersByStartingLetter(@PathVariable String letter){
        return userService.getUserStartingWith(letter);
    }

    @GetMapping("/usersorting")
    public List<User> sortByUser() {
        return userService.sortByUser();
    }
    
}
