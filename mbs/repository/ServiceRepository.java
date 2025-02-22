package com.example.mbs.repository;

import com.example.mbs.entity.ServiceBH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceBH, Integer> {
    // Pagination support
    @SuppressWarnings("null")
    Page<ServiceBH> findAll(Pageable pageable);
}
