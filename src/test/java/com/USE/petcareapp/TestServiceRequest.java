package com.USE.petcareapp;

import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.dto.CreateServiceRequestDto;
import com.USE.petcareapp.enums.Gender;
import com.USE.petcareapp.repos.EmployeeRepository;
import com.USE.petcareapp.services.EmployeeServices;
import com.USE.petcareapp.services.ServiceRequestServices;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

        import static org.assertj.core.api.Assertions.*;
        import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@NoArgsConstructor
public class TestServiceRequest {
    @Autowired
    EmployeeServices employeeServices ;
    @Mock
    EmployeeRepository userRepositoryMock;

    @Before("")
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

   /* @Test
    public void availableEmployeesForOwnerTest() {
    }*/


    @Test
    public void getAvailableEmployeeTest(){
        List<Employee>free= new ArrayList<>() ;
        List<Employee>busy= new ArrayList<>() ;

        Long id = 1L;


        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("karim");
        employee1.setAddress("shobra");
        employee1.setGender(Gender.MALE);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("osama");
        employee2.setAddress("shobra");
        employee2.setGender(Gender.MALE);

        Employee employee3 = new Employee();
        employee3.setId(3L);
        employee3.setName("eslam");
        employee3.setAddress("shobra");
        employee3.setGender(Gender.MALE);

        free.add(employee1);
        free.add(employee2);
        free.add(employee3);

        busy.add(employee1);


        LocalDateTime startDateTime = LocalDateTime.of(2023, 9, 5, 15, 30, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2023, 9, 6, 15, 30, 0);

        when(userRepositoryMock.findAllEmployeeWithSkill(id)).thenReturn(free);
        when(userRepositoryMock.findBusyEmployees(id,startDateTime,endDateTime)).thenReturn(busy);

        List<Employee>freeEmployee=employeeServices.getAvailableEmployee(id , startDateTime ,endDateTime);

        assertThat(freeEmployee.get(0).getId()).isEqualTo(employee2.getId());
        assertThat(freeEmployee.get(1).getId()).isEqualTo(employee3.getId());

    }
}
