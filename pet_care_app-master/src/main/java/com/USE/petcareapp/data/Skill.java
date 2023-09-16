package com.USE.petcareapp.data;

import com.USE.petcareapp.data.Employee;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;

    @ManyToMany(mappedBy = ("skills"))
    List <Employee> employee;

    @OneToMany(mappedBy = ("skill"))
    List<ServiceRequest>serviceRequests;

    private Long duration ;

}
