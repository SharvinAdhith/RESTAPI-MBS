package com.example.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mbs.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findById(int id);
}