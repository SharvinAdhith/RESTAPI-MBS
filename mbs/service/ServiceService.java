package com.example.mbs.service;

import com.example.mbs.entity.ServiceBH;
import com.example.mbs.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceBH> getAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceBH getServiceById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public ServiceBH saveService(ServiceBH service) {
        return serviceRepository.save(service);
    }

    public ServiceBH updateService(int id, ServiceBH service) {
        service.setServid(id);
        return serviceRepository.save(service);
    }

    public void deleteService(int id) {
        serviceRepository.deleteById(id);
    }

    public Page<ServiceBH> getServicesByPage(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return serviceRepository.findAll(pageable);
    }
}
