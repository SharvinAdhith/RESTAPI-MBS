package com.example.mbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbs.entity.ServiceBH;
import com.example.mbs.service.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/getserv")
    public ResponseEntity<List<ServiceBH>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @PostMapping("/postserv")
    public ResponseEntity<ServiceBH> createService(@RequestBody ServiceBH service) {
        return ResponseEntity.ok(serviceService.saveService(service));
    }

    @PutMapping("/updateserv/{id}")
    public ResponseEntity<ServiceBH> updateService(@PathVariable int id, @RequestBody ServiceBH service) {
        return ResponseEntity.ok(serviceService.updateService(id, service));
    }

    @DeleteMapping("/deleteserv/{id}")
    public ResponseEntity<String> deleteService(@PathVariable int id) {
        serviceService.deleteService(id);
        return ResponseEntity.ok("Service deleted successfully");
    }

    @GetMapping("/getserv/{id}")
    public ResponseEntity<ServiceBH> getServiceById(@PathVariable int id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @GetMapping("/pageserv")
    public Page<ServiceBH> getServicesByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
      return serviceService.getServicesByPage(page, size);
    }

    @GetMapping("/servicesorting")
    public List<ServiceBH> getServicesSorting() {
        return serviceService.getServicesSorting();
    }
}
