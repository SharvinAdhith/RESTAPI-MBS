package com.example.mbs.repository;

import com.example.mbs.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findById(int id);
}