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
    @Query(
            value = "SELECT due_date FROM service_request " +
                    "where service_request.employee_id = :employee_id " +
                    "and service_request.due_date between :startDate and :endDate",
            nativeQuery = true)
    List<String> findServiceRequestedByEmployee
            (@Param("employee_id") Long employeeId,
             @Param("startDate") String  startDate,
             @Param("endDate") String endDate);
}

