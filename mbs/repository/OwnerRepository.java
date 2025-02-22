package com.example.mbs.repository;

import com.example.mbs.entity.BoatHouse;
import com.example.mbs.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    // Custom query method
    Owner findByName(String name);

    Owner save(BoatHouse boatHouse);
    
    // Optional is already provided by JpaRepository, so no need to declare it explicitly for findById
}
