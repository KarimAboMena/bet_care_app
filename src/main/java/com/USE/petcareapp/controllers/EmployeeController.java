package com.USE.petcareapp.controllers;

import com.USE.petcareapp.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.USE.petcareapp.services.EmployeeServices;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServices employeeServices;
    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }
    @GetMapping("/get")
    @RolesAllowed("ROLE_ADMIN")
    public List<Employee> getEmployee(){
        return employeeServices.getEmployee();
    }
    @GetMapping("/getId/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public Employee getEmployeeById (@PathVariable("id") long id){
        return employeeServices.getEmployeeById(id);
    }
    @PostMapping("/post")
    @RolesAllowed("ROLE_ADMIN")
    public void registerEmployee(@RequestBody Employee employee){
        employeeServices.addEmployee(employee);
    }
    @PutMapping("/put")
    @RolesAllowed("ROLE_ADMIN")
    public void updateEmployee(@RequestBody Employee employee){
        employeeServices.updateEmployee(employee );
    }
    @DeleteMapping("/delete")
    @RolesAllowed("ROLE_ADMIN")
    public void deleteEmployee(@PathVariable("id") long id){
        employeeServices.deleteEmployee(id);
    }


}
