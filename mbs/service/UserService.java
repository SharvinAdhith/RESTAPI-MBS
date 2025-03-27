package com.example.mbs.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbs.entity.ServiceBH;
import com.example.mbs.entity.User;
import com.example.mbs.exception.ResourceNotFoundException;
import com.example.mbs.repository.ServiceRepository;
import com.example.mbs.repository.UserRepository;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class UserService {
    @Autowired
    private final UserRepository userRepository;
     @Autowired
    private ServiceRepository serviceRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User saveUser(User user) {
        // Create a new user instance with basic info
    User newUser = new User();
    newUser.setName(user.getName());
    newUser.setEmail(user.getEmail());
    newUser.setContactnumber(user.getContactnumber());
    newUser.setPaymentmethod(user.getPaymentmethod());
    
    // First save the user without services
    User savedUser = userRepository.save(newUser);
    
    // Then add each service
    if (user.getServices() != null) {
        for (ServiceBH service : user.getServices()) {
            ServiceBH managedService = serviceRepository.findById(service.getServid())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id: " + service.getServid()));
            savedUser.addService(managedService);
        }
    }
    
    return userRepository.save(savedUser);
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
    public User addServiceToUser(int userId, int serviceId) {
        User user = userRepository.findById(userId).orElseThrow();
        ServiceBH service = serviceRepository.findById(serviceId).orElseThrow();
        user.addService(service);
        return userRepository.save(user);
    }
    public User removeServiceFromUser(int userId, int serviceId) {
        User user = userRepository.findById(userId).orElseThrow();
        ServiceBH service = serviceRepository.findById(serviceId).orElseThrow();
        user.removeService(service);
        return userRepository.save(user);
    }
}