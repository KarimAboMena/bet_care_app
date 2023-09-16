package com.USE.petcareapp.repos;

import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.data.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Long> {
}

