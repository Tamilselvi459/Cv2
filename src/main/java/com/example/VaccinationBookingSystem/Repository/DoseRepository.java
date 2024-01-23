package com.example.VaccinationBookingSystem.Repository;

import com.example.VaccinationBookingSystem.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose, Integer> {
}
