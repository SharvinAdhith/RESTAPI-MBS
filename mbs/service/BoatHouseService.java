package com.example.mbs.service;

import com.example.mbs.entity.BoatHouse;
import com.example.mbs.entity.Booking;
import com.example.mbs.repository.BoatHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BoatHouseService {

    @Autowired
    private BoatHouseRepository boatHouseRepository;
   
    public BoatHouseService(BoatHouseRepository boatHouseRepository) {
        this.boatHouseRepository = boatHouseRepository;
    }

    @Transactional
    public BoatHouse saveBoatHouse(BoatHouse boatHouse) {
       if (boatHouse.getBookings() != null) {
            for (Booking booking : boatHouse.getBookings()) {
                booking.setBoatHouse(boatHouse);
            }
        }
        if (boatHouse.getReserveboatHouse() != null) {
            for (Booking reservation : boatHouse.getReserveboatHouse()) {
                reservation.setReserveBoatHouse(boatHouse);
            }
        }
        return boatHouseRepository.save(boatHouse);
    }

    public BoatHouse updateBoatHouse(int id, BoatHouse boatHouse) {
        boatHouse.setID(id);
        return boatHouseRepository.save(boatHouse);
    }

    public List<BoatHouse> getAllBoatHouses() {
        return boatHouseRepository.findAll();
    }

    public BoatHouse getByBoatHouseName(String name) {
        return boatHouseRepository.findByName(name);
    }

    public String deleteBoatHouse(int id) {
        boatHouseRepository.deleteById(id);
        return "Successfully Deleted The Boat House";
    }

    public Page<BoatHouse> getBoatHouseByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return boatHouseRepository.findAll(pageable);
    }
}
