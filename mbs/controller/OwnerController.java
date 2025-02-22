// package com.example.mbs.controller;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.web.bind.annotation.*;
// import com.example.mbs.entity.Owner;
// import com.example.mbs.service.OwnerService;
// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/apiofowners")
// public class OwnerController {
//     @Autowired
//     private final OwnerService ownerService;

//     public OwnerController(OwnerService ownerService) {
//         this.ownerService = ownerService;
//     }

//     @GetMapping("/owners")
//     public List<Owner> getAllOwners() {
//         return ownerService.getAllOwners();
//     }

//     @PostMapping("/postow")
//     public Owner createOwner(@RequestBody Owner owner) {
//         return ownerService.saveOwner(owner);
//     }

//     @PutMapping("/updateow/{id}")
//     public Owner updateOwner(@PathVariable int id, @RequestBody Owner owner) {
//        return ownerService.updateOwner(id, owner);
//     }

//     @GetMapping("/getow/{name}")
//     public Owner getByOwnerName(@PathVariable String name){
//         return ownerService.getByOwnerName(name);
//     }
//     @GetMapping("/getow/{id}")
//     public Optional<Owner> getByOwnerId(@PathVariable int id){
//         return ownerService.getByOwnerId(id);
//     }
//     @DeleteMapping("/deleteow/{id}")
//     public String deleteOwner(@PathVariable int id){
//         return ownerService.deleteOwner(id);
//     }

//     @GetMapping("/pageow")
//     public Page<Owner> getOwnerByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
//         return ownerService.getOwnerByPage(page, size);
//     }
    

// }
package com.example.mbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mbs.entity.Owner;
import com.example.mbs.service.OwnerService;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/owners")
    public void createOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
    }
    @PutMapping("/updateow/{id}")
    public Owner updateOwnerDetails(@PathVariable int id, @RequestBody Owner owner) {
        owner.setId(id); // Set the ID of the owner to be updated
        ownerService.saveOwner(owner); // Save the updated owner
                return owner;
    }
}
