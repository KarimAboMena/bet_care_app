package com.USE.petcareapp.data;

import com.USE.petcareapp.enums.Gender;
import com.USE.petcareapp.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Type type ;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner ;
}
