package com.example.mbs.controller;

import com.example.mbs.entity.BoatHouse;
import com.example.mbs.service.BoatHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/boathouses")
public class BoatHouseController {
    
    
    @Autowired
    private BoatHouseService boatHouseService;
    
    public BoatHouseController(BoatHouseService boatHouseService) {
        this.boatHouseService = boatHouseService;
    }

    @GetMapping("/getbh")
    public List<BoatHouse> getAllBoatHouses() {
        return boatHouseService.getAllBoatHouses();
    }

    @PostMapping("/postbh")
    public BoatHouse createBoatHouse(@RequestBody BoatHouse boatHouse) {
        return boatHouseService.saveBoatHouse(boatHouse);
    }

    @PutMapping("/updatebh/{id}")
    public BoatHouse updateBoatHouse(@PathVariable int id, @RequestBody BoatHouse boatHouse) {
       return boatHouseService.updateBoatHouse(id, boatHouse);
    }

    @GetMapping("/getbh/{name}")
    public BoatHouse getByBoatHouseName(@PathVariable String name){
        return boatHouseService.getByBoatHouseName(name);
    }
    
    @DeleteMapping("/deletebh/{id}")
    public String deleteBoatHouse(@PathVariable int id){
        return boatHouseService.deleteBoatHouse(id);
    }

    @GetMapping("/pagebh")
    public Page<BoatHouse> getBoatHouseByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
        return boatHouseService.getBoatHouseByPage(page, size);
    }
    

}
