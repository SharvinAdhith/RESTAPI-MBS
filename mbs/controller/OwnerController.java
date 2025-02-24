package com.example.mbs.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mbs.entity.Owner;
import com.example.mbs.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/getowners")
    public List<Owner> getAllOwners() { 
        return ownerService.getAllOwners();
    }

    @PostMapping("/postowners")
    public void createOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
    }
    @PutMapping("/updateowners/{id}")
    public Owner updateOwnerDetails(@PathVariable int id, @RequestBody Owner owner) {
        owner.setId(id); 
        ownerService.saveOwner(owner); 
                return owner;
    }

    @GetMapping("/Ownersort")
    public List<Owner> sortByOwner(){
        return ownerService.sortByOwner();
    }
}
