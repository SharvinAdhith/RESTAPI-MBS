// package com.example.mbs.service;

// import com.example.mbs.entity.Owner;
// import com.example.mbs.repository.OwnerRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class OwnerService {
//     @Autowired
//     private final OwnerRepository ownerRepository;

//     public OwnerService(OwnerRepository ownerRepository) {
//         this.ownerRepository = ownerRepository;
//     }

//     public List<Owner> getAllOwners() {
//         return ownerRepository.findAll();
//     }

//     public Owner saveOwner(Owner owner) {
//         return ownerRepository.save(owner);
//     }

//     public Owner getByOwnerName(String name){
//         return ownerRepository.findByName(name);
//     }

//     public Optional<Owner> getByOwnerId(int id){
//         return ownerRepository.findById(id);
//     }

//     public Owner updateOwner(int id, Owner owner){
//         owner.setId(id);
//         return ownerRepository.save(owner);
//     }
    
//     public String deleteOwner(int id){
//         ownerRepository.deleteById(id);
//         return "Successfully Deleted The Owner Details";
//     }

//     public Page<Owner> getOwnerByPage(int page, int size){
//         Pageable pageable=PageRequest.of(page, size);
//         return ownerRepository.findAll(pageable);
//     }
// }
package com.example.mbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.mbs.entity.BoatHouse;
import com.example.mbs.entity.Owner;
import com.example.mbs.repository.OwnerRepository;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

     public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    // Method to save an Owner
    @Transactional
    public void saveOwner(Owner owner) {
        try {
            ownerRepository.save(owner);
        } catch (OptimisticLockingFailureException e) {
            // Handle the optimistic locking failure (e.g., retry the operation or notify the user)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Optimistic locking failed. Please try again.");
        }
    }

    public Owner updateOwnerDetails(int id, BoatHouse boatHouse){
        boatHouse.setID(id);
        return ownerRepository.save(boatHouse);
    }

    public List<Owner> sortByOwner(){
        return ownerRepository.findAll(Sort.by("id").descending());
    }
}
