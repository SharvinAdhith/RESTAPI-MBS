package com.example.mbs.controller;

import com.example.mbs.entity.ServiceBH;
import com.example.mbs.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<ServiceBH>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceBH> getServiceById(@PathVariable int id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceBH> createService(@RequestBody ServiceBH service) {
        return ResponseEntity.ok(serviceService.saveService(service));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceBH> updateService(@PathVariable int id, @RequestBody ServiceBH service) {
        return ResponseEntity.ok(serviceService.updateService(id, service));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable int id) {
        serviceService.deleteService(id);
        return ResponseEntity.ok("Service deleted successfully");
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<ServiceBH>> getServicesByPage(
        @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(serviceService.getServicesByPage(page, size, sortBy));
    
    }
}
