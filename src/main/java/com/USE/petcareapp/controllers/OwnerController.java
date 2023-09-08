package com.USE.petcareapp.controllers;

import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.data.Owner;
import com.USE.petcareapp.services.EmployeeServices;
import com.USE.petcareapp.services.OwnerServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@AllArgsConstructor
public class OwnerController {

    private final OwnerServices ownerServices;

    @GetMapping("/get")
    public List<Owner> getOwners(){
        return ownerServices.getOwner();
    }
    @GetMapping("/getId/{id}")
    public Owner getOwnerById (@PathVariable("id") long id){
        return ownerServices.getOwnerById(id);
    }
    @PostMapping("/post")
    public void registerOwner(@RequestBody Owner owner){
        ownerServices.addOwner(owner);
    }
    @PutMapping("/put/{id}")
    public void updateEmployee(@PathVariable("id") long id , @RequestBody Owner owner){
        ownerServices.updateOwner(owner);
    }
    @DeleteMapping("/delete")
    public void deleteEmployee(@PathVariable("id") long id){
        ownerServices.deleteOwner(id);
    }


}