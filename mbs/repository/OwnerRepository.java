package com.example.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mbs.entity.BoatHouse;
import com.example.mbs.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Owner findByName(String name);
    Owner save(BoatHouse boatHouse);
}
