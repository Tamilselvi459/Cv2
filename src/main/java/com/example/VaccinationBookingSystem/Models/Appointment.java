package com.example.VaccinationBookingSystem.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String appointmentId;

    @CreationTimestamp
    Date appointmentDate;


     @ManyToOne
     @JoinColumn
     Doctor doctor;

     @ManyToOne
    @JoinColumn
    Person person;
}
