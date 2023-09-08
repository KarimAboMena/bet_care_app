package com.USE.petcareapp.repos;

import com.USE.petcareapp.data.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {

}
