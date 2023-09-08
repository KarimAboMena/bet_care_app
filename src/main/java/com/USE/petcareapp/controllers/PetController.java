package com.USE.petcareapp.controllers;

import com.USE.petcareapp.data.Pet;
import com.USE.petcareapp.services.PetServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@AllArgsConstructor
public class PetController {

    private final PetServices petServices;
    @PostMapping("/post")
    public void addPet(@RequestBody Pet pet){
        petServices.addPets(pet);
    }
    @DeleteMapping("/delete/id")
    public void deletePet(@PathVariable("id") long id){
        petServices.deletePets(id);
    }
}
