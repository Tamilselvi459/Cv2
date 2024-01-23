package com.example.VaccinationBookingSystem.Models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String certificateNo;

    String confirmationMessage;

    @OneToOne
    @JoinColumn
    Person person;
}
