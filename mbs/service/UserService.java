package com.example.mbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.mbs.entity.User;
import com.example.mbs.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getByUserName(String name){
        return userRepository.findByName(name);
    }

    public Optional<User> getByUserId(int id){
        return userRepository.findById(id);
    }

    public User updateUser(int id, User user){
        user.setId(id);
        return userRepository.save(user);
    }
    
    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "Successfully Deleted The User Details";
    }

    public Page<User> getUserByPage(int page, int size){
        Pageable pageable=PageRequest.of(page, size);
        return userRepository.findAll(pageable);

        
    }

    public List<User> getUserStartingWith(String letter) {
        if(letter == null || letter.isEmpty()) {
            throw new IllegalArgumentException("Letter cannot be null or empty");
        }
       return userRepository.findByNameStartingWith(letter + "%");
    }
    public List<User> sortByUser(){
        return userRepository.findAll(Sort.by("name").descending());
    }
}
