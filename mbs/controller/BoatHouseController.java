package com.example.mbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbs.entity.BoatHouse;
import com.example.mbs.service.BoatHouseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/boathouses")
public class BoatHouseController {
      
    @Autowired
    private final BoatHouseService boatHouseService;
    
    public BoatHouseController(BoatHouseService boatHouseService) {
        this.boatHouseService = boatHouseService;
    }

    @GetMapping("/getboathouses")
    public List<BoatHouse> getAllBoatHouses() {
        return boatHouseService.getAllBoatHouses();
    }

    @PostMapping("/postboathouses")
    public ResponseEntity<BoatHouse> createBoatHouse(@Valid @RequestBody BoatHouse boatHouse) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(boatHouseService.saveBoatHouse(boatHouse));
    }

    @PutMapping("/updateboathouses/{id}")
    public ResponseEntity<BoatHouse> updateBoatHouse(
            @PathVariable int id, 
            @Valid @RequestBody BoatHouse boatHouse) {
        return ResponseEntity.ok(boatHouseService.updateBoatHouse(id, boatHouse));
    }
    
    @DeleteMapping("/deleteboathouses/{id}")
    public String deleteBoatHouse(@PathVariable int id){
        return boatHouseService.deleteBoatHouse(id);
    }

    @GetMapping("/getboathouses/{name}")
    public BoatHouse getByBoatHouseName(@PathVariable String name){
        return boatHouseService.getByBoatHouseName(name);
    }
     @GetMapping("/getbh/{id}")
    public ResponseEntity<BoatHouse> getBoatHouseById(@PathVariable int id) {
        BoatHouse boatHouse = boatHouseService.getBoatHouseById(id);
        return ResponseEntity.ok(boatHouse);
    }
    @GetMapping("/pageboathouses")
    public Page<BoatHouse> getBoatHouseByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
        return boatHouseService.getBoatHouseByPage(page, size);
    }
    @GetMapping("/filterbh/{letter}")
    public List<BoatHouse> findByAlphabet(@PathVariable String letter){
        return boatHouseService.findByAlphabet(letter);
    }
}
