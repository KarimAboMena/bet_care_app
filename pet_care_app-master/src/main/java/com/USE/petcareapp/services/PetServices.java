package com.USE.petcareapp.services;

import com.USE.petcareapp.data.Pet;
import com.USE.petcareapp.repos.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetServices {
    private final PetRepository petRepository ;

    public void addPets(Pet pet) {
        petRepository.save(pet);
    }

    public void deletePets(long id) {
        petRepository.deleteById(id);
    }
}
