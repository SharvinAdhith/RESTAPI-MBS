package com.example.mbs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mbs.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Optional<Booking> findById(int id);
}