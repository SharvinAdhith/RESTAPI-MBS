package com.example.mbs.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.mbs.entity.BoatHouse;
import com.example.mbs.exception.ResourceNotFoundException;
import com.example.mbs.repository.BoatHouseRepository;
@Service
public class BoatHouseService {
    @Autowired
    private final  BoatHouseRepository boatHouseRepository;
    @Transactional
    public List<BoatHouse> getAllBoatHouses() {
        return boatHouseRepository.findAll(); // Ensures session is open
    }
    public BoatHouseService(BoatHouseRepository boatHouseRepository) {
        this.boatHouseRepository = boatHouseRepository;
    }
    @Transactional
    public BoatHouse saveBoatHouse(BoatHouse boatHouse) {
        return boatHouseRepository.save(boatHouse);
    }
    public BoatHouse updateBoatHouse(int id, BoatHouse boatHouse) {
        boatHouse.setID(id);
        return boatHouseRepository.save(boatHouse);
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
    public List<BoatHouse> findByAlphabet(String letter){
        if(letter == null || letter.isEmpty()){
            throw new IllegalArgumentException("Letter cannot be null or empty");
        }
        return boatHouseRepository.findByAlphabet(letter);
    }
    public BoatHouse getBoatHouseById(int id) {
        return boatHouseRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("BoatHouse not found with id: " + id));
    }

}