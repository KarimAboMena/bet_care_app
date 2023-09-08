package com.USE.petcareapp.repos;

import com.USE.petcareapp.data.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
