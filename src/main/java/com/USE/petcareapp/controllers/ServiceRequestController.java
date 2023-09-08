package com.USE.petcareapp.controllers;

import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.data.ServiceRequest;
import com.USE.petcareapp.dto.CreateServiceRequestDto;
import com.USE.petcareapp.services.ServiceRequestServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
@AllArgsConstructor
public class ServiceRequestController {

   private final ServiceRequestServices serviceRequestServices ;
    @PostMapping("/post")
    public List<Employee> getAvailableEmployee(@RequestBody CreateServiceRequestDto createServiceRequestDto ) {
        return  serviceRequestServices.availableEmployeesForOwner(createServiceRequestDto);
    }
    @PostMapping("/post/reserve")
    public ServiceRequest reservation(@RequestBody ServiceRequest serviceRequest){

        return serviceRequestServices.makeReservation(serviceRequest);
    }
}
