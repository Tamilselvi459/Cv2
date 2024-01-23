package com.example.VaccinationBookingSystem.Repository;

import com.example.VaccinationBookingSystem.Models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<VaccinationCenter , Integer> {
}
