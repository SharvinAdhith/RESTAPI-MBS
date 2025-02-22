package com.example.mbs.repository;

import com.example.mbs.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
     // Pagination support
     @SuppressWarnings("null")
     Page<Payment> findAll(Pageable pageable);
}
