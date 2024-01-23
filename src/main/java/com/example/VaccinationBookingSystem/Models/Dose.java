package com.example.VaccinationBookingSystem.Models;

import com.example.VaccinationBookingSystem.Enum.DoseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dose {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    String doseId;

    @Enumerated(value = EnumType.STRING)
    DoseType dosetype;

    @CreationTimestamp
    Date VaccinationDate;

    @ManyToOne
    @JoinColumn
    Person person;

}
