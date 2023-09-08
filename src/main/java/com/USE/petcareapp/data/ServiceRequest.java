package com.USE.petcareapp.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequest {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;

   @ManyToOne
   private Employee employee ;

   @ManyToOne
   private Pet pet ;

   @ManyToOne
   Skill skill;

   private LocalDateTime startDate;

   private LocalDateTime endDate;
}
