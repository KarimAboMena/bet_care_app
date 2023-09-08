package com.USE.petcareapp.services;

import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.data.Skill;
import com.USE.petcareapp.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void updateEmployee(Employee employee ) {

        if (Objects.isNull(employee.getId())){
            throw new IllegalStateException("this id is not exist");
        } else {
            if (employee.getName() == null) {
                throw new RuntimeException("please inter your name");
            }
            else {
                employeeRepository.save(employee);
            }
        }
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id){
        Optional<Employee> opt= employeeRepository.findById(id);
        return opt.get();
    }
    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
         boolean exists = employeeRepository.existsById(id);
         if(!exists){
             throw new IllegalStateException("employee with id " + id + "does not exist");
         }
         employeeRepository.deleteById(id);
    }

    public List<Employee> getAvailableEmployee(Long skillId , LocalDateTime startDate ,LocalDateTime endDate) {

        List<Employee> employeesWithSkill =employeeRepository.findAllEmployeeWithSkill(skillId);
        List<Employee> busyEmployee =employeeRepository.findBusyEmployees(skillId,startDate,endDate);

        List <Employee> freeEmployee =new ArrayList<>();

      outerLoop: for(int i =0 ; i<employeesWithSkill.size();i++){
            for(int j = 0 ; j < busyEmployee.size();j++){
                if(employeesWithSkill.get(i).getId().equals(busyEmployee.get(j).getId())) {
                     continue outerLoop;
                }
            }
            freeEmployee.add(employeesWithSkill.get(i));
        }
        return freeEmployee;
    }
}
