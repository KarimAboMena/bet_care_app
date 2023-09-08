package com.USE.petcareapp.repos;

import com.USE.petcareapp.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(
            value = "SELECT * FROM Employee " +
                    "join employee_skills on Employee.id =employee_skills.employee_id " +
                    "where employee_skills.skill_id = :skillId",
            nativeQuery = true)
    List<Employee> findAllEmployeeWithSkill(@Param("skillId") Long skillID);

    @Query(
            value = "SELECT employee.* FROM service_request "+
            "join employee on Employee.id =service_request.employee_id " +
            "where service_request.skill_id = :skillId "+
            "and (service_request.start_date between :startDate and :endDate " +
            "or service_request.end_date between :startDate and :endDate )",
            nativeQuery = true)
    List<Employee> findBusyEmployees
            (@Param("skillId") Long skillID,
             @Param("startDate") LocalDateTime startDate,
             @Param("endDate") LocalDateTime endDate);
}
