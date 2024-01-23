package com.example.VaccinationBookingSystem.Models;

import com.example.VaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int doctorId;

    String name;

    int age;

    @Column(unique = true , nullable = false)
    String emailId;

    Gender gender;

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL)
    List<Appointment> appointmentList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    VaccinationCenter center;

}
