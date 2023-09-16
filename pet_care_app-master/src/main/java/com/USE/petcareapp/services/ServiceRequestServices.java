package com.USE.petcareapp.services;

import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.data.Pet;
import com.USE.petcareapp.data.ServiceRequest;
import com.USE.petcareapp.data.Skill;
import com.USE.petcareapp.dto.CreateServiceRequestDto;
import com.USE.petcareapp.repos.EmployeeRepository;
import com.USE.petcareapp.repos.ServiceRequestRepository;
import com.USE.petcareapp.repos.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceRequestServices {

    private final ServiceRequestRepository serviceRequestRepository;
    private final EmployeeServices employeeServices;
    private final SkillRepository skillRepository;


    public List<Employee> availableEmployeesForOwner(CreateServiceRequestDto createServiceRequestDto) {

        Skill skill = skillRepository.getById(createServiceRequestDto.getSkillId());
        LocalDateTime endTime = createServiceRequestDto.getStartDate().plusMinutes(skill.getDuration());

        List<Employee> freeEmployees = employeeServices.getAvailableEmployee(
                createServiceRequestDto.getSkillId(),
                createServiceRequestDto.getStartDate(),
                endTime
        );

        return freeEmployees;
    }

    public ServiceRequest makeReservation(ServiceRequest serviceRequest) {

        Skill skill = skillRepository.getById(serviceRequest.getSkill().getId());

        LocalDateTime endTime = serviceRequest.getStartDate().plusMinutes(skill.getDuration());
        serviceRequest.setEndDate(endTime);

        List<Employee> freeEmployees = employeeServices.getAvailableEmployee(
                serviceRequest.getSkill().getId(),
                serviceRequest.getStartDate(),
                endTime
        );

        boolean isBusy = true;
        for (Employee employee: freeEmployees) {
            if(employee.getId().equals(serviceRequest.getEmployee().getId())){
                isBusy =  false;
            }
        }
        if(isBusy){
            throw new RuntimeException("Employee is busy");
        }

        return serviceRequestRepository.save(serviceRequest);

    }
}


