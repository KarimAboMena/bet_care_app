package com.USE.petcareapp.services;


import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.data.Owner;
import com.USE.petcareapp.repos.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor //TODO: Nice!!, better than using @Autowired. U can read more: https://www.baeldung.com/java-spring-field-injection-cons
public class OwnerServices {
    private final OwnerRepository ownerRepository;


    public void addOwner(Owner owner) {
       if(owner.getPets()!=null) {
           owner.getPets().forEach(pet -> {
               pet.setOwner(owner);
           });
       }
        ownerRepository.save(owner);
    }

    public List<Owner> getOwner() {
        return ownerRepository.findAll();
    }
    public Owner getOwnerById(Long id){
        Optional<Owner> opt= ownerRepository.findById(id);
        return opt.get(); //TODO: U may use opt.orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void updateOwner(Owner owner) {
        if (Objects.isNull(owner.getId())) {
            throw new IllegalStateException("this id is not exist");
        } else {
            if (owner.getName() != null) {
                ownerRepository.save(owner);
            }
        }
    }

    public void deleteOwner(long id) {
        boolean exists = ownerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("owner with id " + id + "does not exist");  //TODO: Good Formative Error Message, Well Done!
        }
        ownerRepository.deleteById(id);
    }
}
