package com.example.VaccinationBookingSystem.Models;

import com.example.VaccinationBookingSystem.Enum.CenterType;
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
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(value = EnumType.STRING)
    CenterType centerType;

    String centerName;

    String address;

    @OneToMany(mappedBy = "center" , cascade = CascadeType.ALL)
    List<Doctor> doctorList = new ArrayList<>();
}
