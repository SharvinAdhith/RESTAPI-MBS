package com.example.mbs.repository;

import com.example.mbs.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatHouseRepository extends JpaRepository<BoatHouse, Integer> {
    BoatHouse findByName(String name);
}


