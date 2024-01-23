package com.example.VaccinationBookingSystem.Repository;

import com.example.VaccinationBookingSystem.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByEmailId(String oldEmail);
}
