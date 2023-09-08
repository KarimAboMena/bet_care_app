package com.USE.petcareapp.data;

import com.USE.petcareapp.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class Owner {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id ;
     private String name;
     private String address;
     private String phoneNumber;
     private Gender gender;

     @OneToMany(mappedBy=("owner"), cascade = CascadeType.ALL , orphanRemoval = true)
     List<Pet> pets = new ArrayList<>();
}
