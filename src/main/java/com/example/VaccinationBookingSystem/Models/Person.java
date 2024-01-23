package com.example.VaccinationBookingSystem.Models;

import com.example.VaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true , nullable = false)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean Dose1Taken;

    boolean Dose2Taken;

    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL)
    List<Dose> dosetaken = new ArrayList<>();

    @OneToOne(mappedBy = "person" , cascade = CascadeType.ALL)
    Certificate certificate;

    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL)
    List<Appointment> appointmentList = new ArrayList<>();

}
